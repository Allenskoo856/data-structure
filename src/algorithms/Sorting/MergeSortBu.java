package algorithms.Sorting;

/**
 * --------自底向上的归并排序
 *
 *
 * @author : Administrator
 * @create 2018-12-30 14:28
 */
public class MergeSortBu extends sorts {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
    }


}
