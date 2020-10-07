package com.mobile.datastruct.选择排序;

/**
 * @author: douruanliang
 * @date: 2020/9/13
 */
public class SelectSort {

    public static void main(String[] args) {
        selectSort3(new int[]{2, 3, 991, 5, 33, 44, 23, 88, 54});
    }

    /**
     *冒泡排序   不建议 逻辑不是很好
     * @param array
     */
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

    public static void selectSort2(int a[]){


        for (int i =0;i < a.length -1;i++){
            int minIndex = i;  // index 写到这里的话 可以保证那次 默认最小值 都是从未排序的区间找搭配
            for (int j= i+1;j< a.length ; j++){
                if (a[j] < a[minIndex] ){
                    minIndex = j; // 找到最小的索引了
                }
            }

            //交换
            /*** i 从1 ----------length;
             *  1 当前位置 换成最小的
             */
             int temp = a[minIndex];
             a[minIndex] = a[i];
             a[i] = temp;

        }
        for (int k : a
        ) {
            System.out.println(k);
        }
    }

    /**
     *  选择排序 ： 我的理解是，依次找到最小的，放在依次的位置上（换句话说，就是第一次找到最小的放在第一的位置，
     *  第二次找到对小的放在第二的位置，第三次找到最小的放在第三的位置，隐藏的条件是，下一次开始都是未排序的区间）
     * @param a
     */
    public static void selectSort3(int a[]){

        for (int i = 0;i< a.length;i++){ //第几位
             int minIndex = i; //默认起始位置为最小，也就是未排序的第一位（首位置）
            for(int j= i+1; j< a.length;j++){
                if (a[j]< a[minIndex]){
                    minIndex = j; // 记录最小的位置
                }
            }

            int  temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
        for (int k : a){
            System.out.println(k);
        }
    }
}
