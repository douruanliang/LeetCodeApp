package com.mobile.datastruct.希尔排序;

/**
 * @author: douruanliang 不感兴趣
 * @date: 2020/9/13
 */
public class InsertSort {

    public static void main(String[] args) {
        //insertSort(new int[]{2, 3, 1, 5, 33, 44, 23, 88, 54});
        //binaryInsertSort(new int[]{2, 3, 1, 5, 5, 5, 33, 44, 23, 88, 54});
    }


    public static void heerSort(){

    }
    /**
     * 二分插入排序
     * @param array
     */
    public static void binaryInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //待插入到 前面有序序列的值
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid;
            // 8 10 11   <temp =9
            while (left <= right) { // left = 0,right = 2
                mid = (left + right) / 2; // mid = 1
                if (temp > array[mid]) {  // 9 < 10  9>8
                    left = mid + 1;       //left = 1
                } else {
                    right = mid - 1; // right = 0
                }
            }
            // i = 3
            //       2
            // 8 10 11 9
            // 8    10 11
            for (int j= i-1;j>=left;j--){
                //比left右边大的值 往后移动一位，等待temp 的插入
                array[j+1] = array[j];
            }
            if (left!=i){ //i=0,left =1
                array[left] = temp;
            }
        }

        // 输出验证
        show(array);
    }

    /**
     * 直接插入发
     *
     * @param array
     */
    private static void insertSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            //新遍历的值
            int temp = array[i];
            //排序好的  1<- 2<- 4  3,
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 将大于 temp 的数往后以移动一步
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }


    }

    public static void show(int[] array) {
        // 输出验证
        for (int k : array
        ) {
            System.out.println(k);
        }
    }
}
