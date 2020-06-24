package com.github.designpatternlibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: dourl
 * @date: 2020/6/17
 */
public class HashClass {

    static List<? extends Object> list = new ArrayList<>();
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        String result1 = hashMap.put("123", "234");
        String result = hashMap.put("123", "2344");
        System.out.println("result{}" + result);

    }







}
