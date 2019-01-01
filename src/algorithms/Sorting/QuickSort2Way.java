package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;

/**
 * 2路快排问题
 *
 * @author : Administrator
 * @create 2018-12-31 20:30
 */
public class QuickSort2Way extends sorts{

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }


    private static void sort(Comparable[] a, int lo, int hi) {
        // 小数据采用插入排序，优化效率
        if (hi <= lo + 15) { InsertionSort.sort(a, lo, hi); return;};
        int j = partition(a, lo, hi);   // 快速排序的切分功能
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 随机在arr[lo...hi]的范围中, 选择一个数值作为标定点pivot
        swich(a, lo, (int) (Math.random() * (hi - lo + 1)) + lo);
        Comparable p = a[lo];
        int i = lo, j = hi + 1;
        while (true){
            while (less(a[++i],p)) if (i == hi) break;
            while (less(p,a[--j])) if (j == lo) break;
            if (i >= j) break;
            swich(a, i, j);
        }
        swich(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 50);
        SortTestHelper.testSort("algorithms.Sorting.QuickSort2Way", arr);
    }
}
