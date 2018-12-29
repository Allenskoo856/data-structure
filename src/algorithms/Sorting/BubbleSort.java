package algorithms.Sorting;

import algorithms.Sorting.lib.SortTestHelper;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author : Administrator
 * @create 2018-12-29 16:54
 */
public class BubbleSort extends sorts {

    /**
     * ---------冒泡排序--------------------
     * 冒泡排序是每一轮只比较和交换后一个元素，在内循环中对于第i次循环，需要比较的次数总是n-i次，
     * 对于最坏的情况，逆序而言需要交换1/2*(N-1)(N-1)次
     *  其时间复杂度为O(n^2)
     * @param arr arr[]
     */
    public static void sort(Comparable[] arr){
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (less(arr[j], arr[j - 1]))
                    swich(arr, j -1, j);
            }
        }
    }

    public static void main(String[] args) {
        int N = 25000;
        // 测试1 对比冒泡、选择排序、插入排序
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("algorithms.Sorting.BubbleSort", arr1);
        SortTestHelper.testSort("algorithms.Sorting.InsertionSort", arr2);
        SortTestHelper.testSort("algorithms.Sorting.SelectionSort", arr3);

        System.out.println();
    }
}
