package com.github.designpatternlibrary.java;

/**
 * @author: dourl
 * @date: 2020/7/24
 *
 * 静态内部类和非静态内部类的区别
 */
public class TestInner {

    private int number = 100;
    public int sex = 0;

    static int staticSex = 1;
    class InnerClass {

        int number = 99;

        public void show(){
            System.out.println(number);
            System.out.println(this.number);
            System.out.println(sex);
            System.out.println(staticSex);
            System.out.println(TestInner.this.number);
        }
    }


     static class StaticInnerClass {
         private int number =98;
         static String  address = "xxx";

         public void show(){

             // int s = TestInner.this.sex;
             int ss = staticSex;
            // 区别1 ： 静态内部类只能访问，外部类的静态成员属性和方法，
             // 而非静态内部类因为持有外部类的引用所以可以访问外部类的所有成员

             //  区别2 ：非静态内部类的实例，需要new关键字的，而静态内部类不需要，只需外部类的实例+"." 即可
         }



         static class StaticInnerInnerClass{
             static String  address = "xxx+ss";
         }
    }


    public static void main(String[] args) {

        TestInner testInner = new TestInner();
        //非静态内部类
        InnerClass innerClass = testInner.new InnerClass();
        innerClass.show();
        InnerClass innerClass2 = new TestInner().new InnerClass();

        TestInner.StaticInnerClass staticInnerClass = new TestInner.StaticInnerClass();


        System.out.println(staticInnerClass.number);

        TestInner.StaticInnerClass.StaticInnerInnerClass  innerInnerClass= new TestInner.StaticInnerClass.StaticInnerInnerClass();

        System.out.println(innerInnerClass.address);
    }
}
