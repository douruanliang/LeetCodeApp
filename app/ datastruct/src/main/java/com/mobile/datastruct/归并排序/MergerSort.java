package com.mobile.datastruct.归并排序;

/**
 * @author: douruanliang
 * @date: 2020/9/16
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 5, 33, 1023, 44, 23, 88, 54, 100};
        MergerSort sort = new MergerSort();
        sort.mergerSort(array,0,array.length-1);
        // 输出验证
        for (int k : array
        ) {
            System.out.println(k);
        }
    }

    private void mergerSort(int[] a,int left,int right){
        if (left<right){
            int middle = (left+right)/2;
            mergerSort(a,left,middle);
            mergerSort(a,middle+1,right);
            merger(a,left,middle,right); //合并
        }

    }

    private void merger(int[] a, int left, int middle, int right) {
        int [] tempArray = new int[a.length];
        int temp = left; // third
        int r_temp = left;
        int rightStart = middle+1;
        //在边界范围 小的先放进数组
        while (left<=middle && rightStart<=right){
            if (a[left]<= a[rightStart]){
                //赋值再移位
                tempArray[temp++] = a[left++];
            }else{
                tempArray[temp++] = a[rightStart++];
            }
        }
        //当跳出说明 两个小组必有一个已经全部放进临时新的数组中
        //放进剩下的元素（左边）
        while (left<= middle){
            tempArray[temp++] = a[left++];
        }
        //放进剩下的元素（右边）
        while (rightStart<=right){
            tempArray[temp++] = a[rightStart++];
        }
        //返回 ->a
        while (r_temp<=right){
            a[r_temp] = tempArray[r_temp++];
        }
    }
}
