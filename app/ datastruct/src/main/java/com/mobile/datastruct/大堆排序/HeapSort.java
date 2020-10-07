package com.mobile.datastruct.大堆排序;

/**
 * @author: douruanliang
 * @date: 2020/9/15
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 1, 10, 4};
        HeapSort heapSort = new HeapSort();
        // heapSort.heapSort(array);
        int n = array.length;

        //heapSort.build_Heap(array,n);
        heapSort.heap_sort2(array, n);
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


    /**
     * 构堆
     *
     * @param a 堆对应的数组
     * @param n 数组长度
     * @param i 第i个下标
     */
    void heapify(int a[], int n, int i) {
        if (i >= n) { // max传进来的
            return;
        }
        int c1 = 2 * i + 1; //左子节点下标
        int c2 = 2 * i + 2; //右子节点下标
        int max = i; // 假设这个下标的对应的数值最大

        if (c1 < n && a[c1] > a[max]) {
            max = c1;
        }
        if (c2 < n && a[c2] > a[max]) {
            max = c2;
        }
        if (max != i) {
            exchangeElements(a, max, i);
            heapify(a, n, max); // 之前通过交换，现在需要对 max 的下面的 节点递归
        }

    }

    /**
     * @param a 没有序的数组
     * @param n 数组的长度
     */
    void build_Heap(int a[], int n) {
        int last_index = n - 1; //i
        int last_parent = (last_index - 1) / 2; // 最后一个节点的的父亲的数组下标
        // 从下到上做 heapfiy

        for (int i = last_parent; i >= 0; i--) {
            heapify(a, n, i);

        }
    }

    /**
     * 将 根节点和最后一个节点交换 并移除最后一个节点 即最大值砍掉
     */
    void heap_sort(int a[], int n) {
        // 第一步 建立堆
        build_Heap(a, n); // 最大的一定在上面
        // i 为数组下标
        for (int i = n - 1; i >= 0; i--) {
            // ii 每次交换 i 和第 0 个节点 （根节点）
            swap(a, i, 0);
            // iii 下沉
            heapify(a, i, 0);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }


    void heap_sort2(int a[], int n) {

        // i 建立堆
        build_heap2(a, n);
        // ii 排序 （最后一个换到最后）
        for (int i = n - 1; i >= 0; i--) {
            swap(a,i,0); // 将最后一个换到 根
            heapify2(a,i,0); //  对根做 heapify
        }

    }

    /**
     * 建立堆 满足 1 节点大于 子节点 2 连续的
     *
     * @param a
     * @param n
     */
    private void build_heap2(int[] a, int n) {

        int last_index = n - 1;
        int last_parent_index = (last_index - 1) / 2;
        // 从后往前 倒着 heapfy
        for (int i = last_parent_index; i >= 0; i--) {
            heapify2(a, n, i);
        }
    }

    /**
     * @param a 用数组代表的树
     * @param n 数组的长度（节点的个数）
     * @param i 对那个节点做 heapify (数组下边) (从上->下)
     */
    private void heapify2(int a[], int n, int i) {

        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max_index = i;
        if (c1 < n && a[c1] > a[max_index]) {
            max_index = c1;
        }
        if (c2 < n && a[c2] > a[max_index]) {
            max_index = c2;
        }
        if (max_index != i) {
            swap(a, max_index, i);
            heapify2(a, n, max_index);
        }
    }

}
