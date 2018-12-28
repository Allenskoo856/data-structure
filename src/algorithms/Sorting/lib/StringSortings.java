package algorithms.Sorting.lib;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * @author : Administrator
 * @create 2018-12-28 19:51
 */
public class StringSortings {
    public static void main(String[] args) {

        String[] a = In.readStrings("D:\\Project\\mywokes\\data-structure\\src\\data\\words3.txt");
        Insertion.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] +" ");
        }

    }
}
