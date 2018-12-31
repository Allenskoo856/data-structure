package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * 插入排序
 *
 * @author : Administrator
 * @create 2018-12-28 21:52
 */
public class InsertionSort extends sorts {

    /**
     * --------插入排序-----------------------------------------
     * 插入排序思想，将设定i指针左边的为排序完成，右边的为未排序，j作为内层指针，
     * 每次循环比较前面的元素，若小则向前移动，否则不变。
     * 分析： 外循环最少要走 N - 1次，内循环时间为看数组而定。
     * 最好的情况：已经有序的数组，仅需要N-1次比较即可
     * 最坏的情况：完全逆序的数组，需要~1/2N^2比较-~1/2N^2次交换
     * 其时间复杂度为o(n^2)
     *
     * @param a arr[]
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swich(a, j, j - 1);
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j >lo && less(a[j],a[j -1]) ; j--) {
                swich(a, j ,j -1);
            }
        }
    }

    /**
     * Exercise 2.1.18
     *
     * @param a []
     */
    public static void drawSort(Comparable[] a) {
        int N = a.length;
        StdDraw.setYscale(N + 3, 0);
        StdDraw.setXscale(0, N + 3);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(3 + N / 2, 0.4, "a[ ]");
        StdDraw.text(1, 1, "i");
        StdDraw.text(2, 1, "j");
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, 1, i + "");
            StdDraw.text(3 + i, 2, a[i].toString());
        }
        StdDraw.line(0, 1.5, N + 3, 1.5);
        for (int i = 1; i < N; i++) {
            StdDraw.text(1, 2 + i, i + "");
            int red = i;
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swich(a, j, j - 1);
                red = j - 1;
                StdDraw.text(3 + j, 2 + i, a[j].toString());
            }
            StdDraw.text(2, 2 + i, red + "");
            StdDraw.setPenColor(Color.RED);
            StdDraw.text(3 + red, 2 + i, a[red].toString());
            StdDraw.setPenColor(Color.GRAY);
            for (int k = 0; k < N; k++) {
                if (k < red || k > i) {
                    StdDraw.text(3 + k, 2 + i, a[k].toString());
                }
            }
            StdDraw.setPenColor(Color.BLACK);
        }
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, N + 2, a[i].toString());
        }
    }


    public static void main(String[] args) {
        int N = 15;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 150);
        SortTestHelper.testSort("algorithms.Sorting.InsertionSort", arr);
        SortTestHelper.testSort("algorithms.Sorting.InsertionSort", arr1);

        InsertionSort.drawSort(arr);
    }
}
