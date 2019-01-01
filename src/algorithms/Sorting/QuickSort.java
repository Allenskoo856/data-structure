package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;

/**
 * 快速排序
 *
 * @author : Administrator
 * @create 2018-12-31 15:47
 */
public class QuickSort extends sorts {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    protected static void sort(Comparable[] a, int lo, int hi) {
        // 小数据采用插入排序，优化效率
        if (hi <= lo + 15) { InsertionSort.sort(a, lo, hi);return;};
        int j = partition(a, lo, hi);   // 快速排序的切分功能
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // 对arr[lo...hi]部分进行partition操作
    //  arr: lo --- p-1 -- p -- p+1 -----hi  保证前两部分呢都排好序
    // 返回p, 使得arr[lo...p-1] < arr[p] ; arr[p+1...hi] > arr[p]
    private static int partition(Comparable[] a, int lo, int hi) {
        // 定义 arr[lo+1...j] < p, arr[j+1...i-1] > p
        /*  图示数组：  p | ---  <p --- | --- >p ---| e
         *
         *   索引     lo | ---------- |j|-------| i
         * */
        // j是使得a[j]<p最后一个索引，i为从头往前遍历的索引，p=a[lo] 为基准
        // 随机在arr[lo...hi]的范围中, 选择一个数值作为标定点pivot
        // 随机生成lo-hi之间的索引
        swich(a, lo, (int) (Math.random() * (hi - lo + 1)) + lo);
        Comparable p = a[lo];
        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], p)) {
                swich(a, j + 1, i);
                j++;
            }
        }
        swich(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 10);
        SortTestHelper.testSort("algorithms.Sorting.QuickSort", arr1);
        SortTestHelper.testSort("algorithms.Sorting.MergeSort", arr1);
    }

}
