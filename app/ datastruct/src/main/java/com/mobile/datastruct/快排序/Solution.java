package com.mobile.datastruct.快排序;

/**
 * @author: douruanliang
 * @date: 2020/9/10
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 5, 33, 1023, 44, 23, 88, 54, 100};

        //int[] array = new int[]{2, 3, 1, 5,10};
        Solution solution = new Solution();
        solution.quick(array);
        // 输出验证
        for (int k : array
        ) {
            System.out.println(k);
        }
    }

    private void quick(int[] array){
        quickSort(array,0,array.length-1);
    }
    /**
     *
     * @param data
     * @param low 低位下标
     * @param high 高位下标
     */
    private void quickSort(int data[],int low,int high){

        if (low< high){
            //找到中间值（即index）
            int middle = getMiddle(data,low,high);
            //左边区域
            quickSort(data,0,middle-1);
            //右边区域
            quickSort(data,middle+1,high);
        }

    }
    /**
     * 找到 一个基准位置
     * @param data
     * @param left
     * @param right
     * @return
     */
    public  int getMiddle (int data[],int left,int right){
        int temp = data[left] ; //默认基准元素
        //以下是找这个基准元素的位置
        while (left < right){
            while (left <right && data[right]>= temp){
                right--;
                System.out.println("我从右边出发，向左前进找小基准数的数");
            }
            //一旦跳出循环，说明此时遇到小于的基数，
            // 那么交换一下，目的是为了下面的循环 更右可能好的排序，毕竟上面的while 体有限执行
            data[left] = data[right];
            while (left <right && data[left]<= temp){
                left++;
                System.out.println("我从左边出发，向右前进找大于基准数的数");
            }
            //一旦跳出说明遇到大于
            data[right] = data[left];
        }
        //当退出最上层循环 ，左右相遇了 说明 找到合适的位置了
        data[left] = temp ;
        return left;
    }
}
