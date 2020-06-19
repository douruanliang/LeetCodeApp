package com.github.designpatternlibrary;

import java.util.HashMap;

/**
 * @author: dourl
 * @date: 2020/6/17
 */
public class HashClass {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        String result1 = hashMap.put("123", "234");
        String result = hashMap.put("123", "2344");
        System.out.println("result{}" + result);
    }
}
