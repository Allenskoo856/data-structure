package algorithms.Sorting.lib;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author : Administrator
 * @create 2018-12-28 19:48
 */
public class Experiment {
    public static void main(String[] args) {
        int N = Integer.parseInt("10");
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Insertion.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
