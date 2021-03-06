package algorithms.Sorting.lib;

import java.lang.reflect.Method;

/**
 * @author : Administrator
 * @create 2018-12-28 19:14
 */
public class SortTestHelper {
    private SortTestHelper() {
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     *
     * @param n      n个元素
     * @param rangeL 随机数组下限
     * @param rangeR 随机数组上限
     * @return Integer[]
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL < rangeR : "something goes wrong here;";
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * (rangeL - rangeR + 1) + rangeL);
        return arr;
    }

    /**
     * // 生成一个近乎有序的数组
     * // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
     * // swapTimes定义了数组的无序程度:
     * // swapTimes == 0 时, 数组完全有序
     * // swapTimes 越大, 数组越趋向于无序
     *
     * @param n         n个元素
     * @param swapTimes 随机交换swapTimes对数据
     * @return Integer[]
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }

    /**
     * 生成一个完全有序的数组
     *
     * @param n n个元素
     * @return Integer[]
     */
    public static Integer[] generateOrderedArray(int n) {

        return generateNearlyOrderedArray(n, 0);
    }


    /**
     * 生成一个完全逆序的数组
     *
     * @param n n个元素
     * @return Integer[]
     */
    public static Integer[] generateInverseArray(int n) {
        Integer[] arr = generateOrderedArray(n);
        for (int i = n / 2 - 1; i >= 0; i--) {
            Integer t = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = t;
        }
        return arr;
    }

    /**
     * 打印arr数组的所有内容
     *
     * @param arr arr[]
     */
    public static void printArray(Object arr[]) {
        for (Object i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    /**
     * 判断arr数组是否有序
     *
     * @param arr Comparable[] arr
     * @return boolean
     */
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }


    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr) {

        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", Comparable[].class);
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
