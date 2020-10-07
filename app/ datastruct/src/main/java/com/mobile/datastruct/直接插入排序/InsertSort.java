package com.mobile.datastruct.直接插入排序;

/**
 * @author: douruanliang
 * @date: 2020/9/13
 */
public class InsertSort {

    public static void main(String[] args) {
        insertSort3(new int[]{2, 3, 1, 5});
        //binaryInsertSort(new int[]{2, 3, 1, 5, 5, 5, 33, 44, 23, 88, 54});
    }

    public static void binaryInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //待插入到 前面有序序列的值
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid;
            // 8 10 11   <temp =9   // 因为默认是排好的可以 二分
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
        show(array);

    }


    public static  void insertSort2(int []arr){

        for (int i =0;i< arr.length;i++){
            int x = arr[i]; // 暂存带插入的数       （1）
            int j; //带比较的位置 （待插入对象的 前一个）
            for (j= i-1;j>=0;j--){  // （2）假设在排好序的 移动合适的位置
                if (arr[j] > x){
                    arr[j+1] = arr[j]; //后移动
                }
            }
            arr[j+1] = x;// （3）
        }
        // 输出验证
        show(arr);
    }

    public static void insertSort3(int [] a){
        for (int i=0; i < a.length ; i++){
            int x = a[i];
            int j = 0;
            for (j= i-1;j>=0;j--){
                if (a[j] > x){
                    //腾出位置
                    a[j+1] = a[j]; //后移 也就是前一个覆盖后一个 //
                }else{ // 如果待插入的大于退出，否则 （
                       // for 循环会一只执行, // 2,3,1,5 到5 的时候 前面的排序为 1,2,3--- 5 ,j 的值就为 2--1-->0,
                       // 循环后 a[1] = 5,整个数组就会变成 5，3，3，5）
                    break;
                }
            }
            //
            a[j+1] = x ; //插入
        }
        // 输出验证
        show(a);
    }


    public static void show(int[] array) {
        // 输出验证
        for (int k : array
        ) {
            System.out.println(k);
        }
    }
}
