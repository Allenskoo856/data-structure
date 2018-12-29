package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;

/**
 * @author : Administrator
 * @create 2018-12-29 18:08
 */
public class ShellSort extends sorts {

    /**
     * ---------希尔排序----------------------------
     *  希尔排序基于插入排序而成的,对每段增量计算不同而导致的
     *  希尔排序使用3X+1的增量最差的时间复杂度为
     *  O(N^3/2).
     * @param a arr
     */
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N /3) h = 3 * h + 1;// 1 4 13 40 121 364 ...
        while (h >= 1) {
            // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
            for (int i = h; i < N; i++) {
                for (int j =i; j >= h && less(a[j],a[j-h]); j -= h)
                    swich(a, j, j-h);
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort("algorithms.Sorting.ShellSort", arr1);
    }
}
