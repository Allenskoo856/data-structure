package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.*;


/**
 * @author : Administrator
 * @create 2018-12-28 20:16
 */
public class SelectionSort extends sorts {

    /**
     * ------选择排序-------------------------------------------------
     * 先找到数组的最小值，将其与数组第一个元素交换,然后i后移，找到剩余的元素的最小值，
     * 将其与第二个元素交换，依次类推。
     * 对于长度为N的数组，选择排序需要N次交换和（N-1）+（N-2）+...+2+1~~N^2/2次比较
     * 其时间复杂度为o（n^2）
     * 特点： 1. 运行时间与输入无关，有序数组输入和近乎有序数组基本一致
     * 2. 数据移动是最少的。选择排序用了N次交换
     *
     * @param a arr[]
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 找到【i，n）之间的最小值的索引
            int minIndex = i; // 最开始的最小索引定为 开始的 i
            for (int j = i + 1; j < N; j++) {
                // 判断i之后的每个值，如果有值比其小，则最小索引改变
                if (less(a[j], a[minIndex])) minIndex = j;
            }
            swich(a, i, minIndex); // 内层循环完之后交换最小索引与i的值，同时i指针前移动一位
        }
    }

    /**
     * Exercise 2.1.18
     *
     * @param a
     */
    public static void drawSort(Comparable[] a) {
        int N = a.length;
        StdDraw.setYscale(N + 4, 0);
        StdDraw.setXscale(0, N + 3);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(3 + N / 2, 0.4, "a[ ]");
        StdDraw.textRight(1, 1, "i");
        StdDraw.textRight(2, 1, "min");
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, 1, i + "");
            StdDraw.text(3 + i, 2, a[i].toString());
        }
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            StdDraw.textRight(1, 3 + i, i + "");
            StdDraw.textRight(2, 3 + i, min + "");
            StdDraw.setPenColor(Color.GRAY);
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    StdDraw.setPenColor(Color.BLACK);
                }
                if (j == min) {
                    StdDraw.setPenColor(Color.RED);
                }
                StdDraw.text(3 + j, 3 + i, a[j].toString());
                if (j == min) {
                    StdDraw.setPenColor(Color.BLACK);
                }
            }
            swich(a, i, min);
        }
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, N + 3, a[i].toString());
        }
    }

    public static void main(String[] args) {

        Integer[] arr = SortTestHelper.generateRandomArray(2000, 0, 10000);

        Stopwatch timer = new Stopwatch();
        SelectionSort.sort(arr);
        System.out.println("SelectionSort sort for 20000 Random Numbers: " + timer.elapsedTime() + "s");
    }
}
