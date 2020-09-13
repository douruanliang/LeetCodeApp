package com.mobile.datastruct.选择排序;

/**
 * @author: douruanliang
 * @date: 2020/9/13
 */
public class SelectSort {

    public static void main(String[] args) {
        selectSort(new int[]{2, 3, 1, 5, 33, 44, 23, 88, 54});
    }

    private static void selectSort(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    array[j] = array[i];
                    array[i] = min;
                }
            }
        }
        for (int k : array
        ) {
            System.out.println(k);
        }
    }
}
