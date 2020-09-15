package com.mobile.datastruct.快排序;

/**
 * @author: douruanliang
 * @date: 2020/9/10
 */
public class Solution {

    public static int pivot (int data[],int left,int right){

        int pivot = data[left] ; // 区左边
        while (left < right){
            while (left<right && data[right]>= data[pivot]){
                right --;
            }
            data[left] = data[right];
            while (left<right && data[left]<= data[pivot]){
                right --;
                data[right] = data[left];
            }
        }

        return pivot;
    }
}
