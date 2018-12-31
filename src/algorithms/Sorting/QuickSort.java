package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;

/**
 * 快速排序
 *
 * @author : Administrator
 * @create 2018-12-31 15:47
 */
public class QuickSort extends sorts {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length -1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int j = partition(a, lo ,hi);   // 快速排序的切分功能
        sort(a, lo, j -1);
        sort(a, j + 1, hi);
    }

    // 对arr[lo...hi]部分进行partition操作
    //  arr: lo --- p-1 -- p -- p+1 -----hi  保证前两部分呢都排好序
    // 返回p, 使得arr[lo...p-1] < arr[p] ; arr[p+1...hi] > arr[p]
    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable p = a[lo];
        int j = lo;
        for (int i = lo +1; i <= hi ; i++) {
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
        SortTestHelper.testSort("algorithms.Sorting.QuickSort", arr);
    }

}
