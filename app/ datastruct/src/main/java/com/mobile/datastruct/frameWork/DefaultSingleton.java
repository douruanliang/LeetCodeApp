package com.mobile.datastruct.frameWork;

/**
 * @author: douruanliang
 * @date: 2020/9/15
 */
public class DefaultSingleton {

    private static final Singleton<DeFault> gDefault = new Singleton<DeFault>() {
        @Override
        protected DeFault create() {
            return new DeFault();
        }
    };

    public static DeFault getDeFault() {
        return gDefault.get();
    }

}
