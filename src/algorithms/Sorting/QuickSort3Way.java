package algorithms.Sorting;


import algorithms.Sorting.lib.SortTestHelper;

/**
 * 3路快排
 *
 * @author : Administrator
 * @create 2018-12-31 20:32
 */
public class QuickSort3Way extends sorts {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * ----------------三路快排---
     *
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        // 小数据采用插入排序，优化效率
        if (hi <= lo + 15) { InsertionSort.sort(a, lo, hi); return;};
        int lt = lo, gt = hi;
        Comparable p = a[lo];
        int i = lo;
        while (i <= gt){
            int cmp = a[i].compareTo(p);
            if (cmp < 0) swich(a, lt++, i++);
            else if (cmp > 0) swich(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    public static void main(String[] args) {
        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0,  10);
        SortTestHelper.testSort("algorithms.Sorting.QuickSort3Way", arr);
        SortTestHelper.testSort("algorithms.Sorting.QuickSort2Way", arr);
    }

}
