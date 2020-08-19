package com.github.designpatternlibrary.java;

/**
 * @author: dourl
 * @date: 2020/7/16
 */
public class Banana extends Fruit {

    static String color = "青色";

    /**
     * 这叫覆盖
     */
    static public void call() {
        System.out.println("这是一个香蕉");
    }

    String call1() {
        System.out.println("这是一个call1");

        int i = 2;

        try {
            //i = i / 0;
            return i + "try";
        } catch (Exception e) {
            e.printStackTrace();
            return i + "catch";
        } finally {
            return i + "finally";
        }

    }

    int callString(String s) {
        try {
            return s.charAt(0) - '0';
        } catch (NullPointerException e) {
            System.out.println("这是一个NullPointerException");
            return 1;
        } catch (StringIndexOutOfBoundsException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        } finally {
            System.out.println("这是一个finally");
            return 4;
        }


    }

    public static void main(String[] args) {


    /*    Fruit fruit = new Banana();

        //重写
        System.out.println(fruit.color);
        fruit.call();
*/

        Banana banana = new Banana();
        //String result = banana.call1();

        System.out.println(banana.callString(null)+","+banana.callString("0"));
    }
}
