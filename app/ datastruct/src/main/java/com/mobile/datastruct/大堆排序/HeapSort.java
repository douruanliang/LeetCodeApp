package com.mobile.datastruct.大堆排序;

/**
 * @author: douruanliang
 * @date: 2020/9/15
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 5, 33, 1023, 44, 23, 88, 54, 100};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);

        // 输出验证
        for (int k : array
        ) {
            System.out.println(k);
        }
    }

    public void heapSort(int[] a) {
        if (a == null || a.length == 0) return;
        buildMaxHeap(a); //已经有最大的元素
        //最大元素已经排在了下标为0的地方
        for (int i = a.length - 1; i >= 1; i--) {

            //每次换一次，就沉淀一个大元素
            exchangeElements(a, 0, i);
            maxHeap(a, i, 0);
        }
    }

    /**
     * 构建大堆
     *
     * @param a
     */
    private void buildMaxHeap(int[] a) {
        int half = (a.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(a, a.length, i);
        }

    }

    /**
     * @param a
     * @param length 用于构造大堆的数组长度
     * @param i      从那个开始
     */
    private void maxHeap(int[] a, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i; //相当于记录index

        if (left < length && a[left] > a[i]) {
            largest = left;  // 判断左边最大 记录下
        }
        if (right < length && a[right] > a[largest]) {
            largest = right;  //判断右边谁最大 记录下
        }
        System.out.println("largest:" + largest);
        if (i != largest) {
            //进行交换
            exchangeElements(a, i, largest);
            maxHeap(a, length, largest);
        }

    }

    private void exchangeElements(int[] a, int i, int largest) {
        int temp = a[i];
        System.out.println("largest:" + largest);
        a[i] = a[largest];  //直到 i=0；
        a[largest] = temp;
    }
}
