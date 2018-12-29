package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;

/**
 * @author : Administrator
 * @create 2018-12-29 21:34
 */
public class MergeSort extends sorts {

    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo...hi] 排序
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;   // 防止整数溢出
        sort(a, lo, mid);               // 左边排序
        sort(a, mid + 1, hi);       // 右边排序
        if (!less(a[mid],a[mid+1]))     // 如果arr[mid] < arr[mid + 1]则数组本身已经有序，无需归并
            merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi){
        // 归并a【lo，mid】和a【mid+1，hi】
        int i = lo, j = mid + 1;                // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        for (int k = lo; k <= hi; k++)          // a[lo..hi] copy in aux[lo..hi]
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {                            // K 的指针是a的索引指针,i j 为复制后aux数组索引
            if (i > mid)                        a[k] = aux[j++];    // 如果左半部分元素已经全部处理完毕,赋值右边元素
            else if (j > hi)                    a[k] = aux[i++];    // 如果右半部分元素已经全部处理完毕,赋值左边元素
            else if (less(aux[i],aux[j]))       a[k] = aux[i++];    // 索引未越界的情况，比较a[i],a[j] 大小取较小的赋值
            else                                a[k] = aux[j++];    // 同上,记得每次赋值后维护索引前移既i++，j++
         }
    }

    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("algorithms.Sorting.MergeSort", arr);
    }
}
