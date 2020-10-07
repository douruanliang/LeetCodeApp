package com.mobile.datastruct.快排序;

/**
 * @author: douruanliang
 * @date: 2020/10/6
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 5, 33, 1023, 44, 23, 88, 54, 100};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort4(array,0,array.length-1);

        // 输出验证
        for (int k : array
        ) {
            System.out.println(k);
        }

    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {

            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }
            // 程序走到这里是 因为找到小于基准数的 ，不然一只在循环里面--
            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }


    public void quickSort1(int[]a,int left,int right){
        if (left >= right)
            return;

        int l_index = left;
        int r_index = right;

        int pivot = a[l_index]; //基准点

        while (r_index > l_index){
             while (r_index > l_index && a[r_index]> pivot){
                 r_index--;
             }
             a[l_index] = a[r_index];
             while (l_index < r_index && a[l_index] < pivot){
                 l_index++;
             }
             a[r_index] = a[l_index];

        }
        // 如果跳出说明 l_index = r_index 也就是 pivot的坐标点
        a[l_index] = pivot;
        // 递归pivot 左边的
        quickSort1(a,left,l_index-1);
        quickSort1(a,r_index+1,right);
    }

    public void quickSort2(int[] a, int l,int r){
        // 终止条件
        if (l>= r) return;

        int i = l;
        int j = r;
        int pivot = a[i];

        while (i<j){
            while (j>i && a[j] > pivot){
                j--;
            }
            a[i] = a[j];
            while (i<j && a[i]< pivot){
                i++;
            }
            a[j] = a[i];
        }
        // i = j
        a[i] = pivot;
        quickSort2(a,l,i-1);
        quickSort2(a,i+1,r);

    }


    public void quickSort3(int a[],int left,int right ){

        if (left >= right){
            return;
        }

        int l = left;
        int r = right;
        int pivot = a[l];

        while (l < r){
            while (r > l && a[r] > pivot){
                r--;
            }
            a[l] = a[r];
            while (l < r && a[l] < pivot){
              l++;
            }
            a[r] = a[l];
        }
        a[l] = pivot ; //定位置

        quickSort3(a,left,l-1);
        quickSort3(a,l+1,right);
    }

    public void quickSort4(int a[],int left,int right){
        if (left >= right) return;

        int i = left;
        int j = right;
        int pivot  = a[i];

        while (j>i){
            while (j > i && a[j]> pivot){
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i]<pivot){
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        quickSort4(a,left,i-1);
        quickSort4(a,i+1,right);
    }
}
