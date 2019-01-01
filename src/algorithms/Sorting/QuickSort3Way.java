package algorithms.Sorting;


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

    private static void sort(Comparable[] a, int lo, int hi) {
        // 小数据采用插入排序，优化效率
        if (hi <= lo + 15) { InsertionSort.sort(a, lo, hi); return;};
        int j = partition(a, lo, hi);   // 快速排序的切分功能
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        return 0;
    }


}
