package com.github.designpatternlibrary;

import android.content.Context;

/**
 * @author: dourl
 * @date: 2020/6/10
 */
public class Strategy {


    /**
     * Strategy 及其子类为组件提供了一系列可重用的算法，从而可以使得类型在运行时方便第更具需要在各个算法之间
     * 进行切换
     * <p>
     * Strategy 模式提供了用条件判断语句以外的另一种选择，消除条件判断语句，就是解偶
     */
    abstract class TaxStrategy {
        abstract double calculate(Context context);
    }


    /**
     * 中国的税法
     */
    public class CNTax extends TaxStrategy {

        @Override
        double calculate(Context context) {
            return 0;
        }
    }


    /**
     * 美国的税法
     */
    public class USTax extends TaxStrategy {

        @Override
        double calculate(Context context) {
            return 0;
        }
    }


    public class SalesOrder {
        TaxStrategy mTaxStrategy;

        public SalesOrder(TaxStrategy mTaxStrategy) {
            this.mTaxStrategy = mTaxStrategy;
        }

        public double CalculateTax(Context context) {
            return mTaxStrategy.calculate(context);
        }

    }
}
