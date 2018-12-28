package algorithms.Sorting;

/**
 * @author : Administrator
 * @create 2018-12-28 19:36
 */
public class sorts {

   static void sort(Comparable[] a){};

   static boolean less(Comparable<Comparable> v, Comparable w){
       return v.compareTo(w) < 0;
   };


   static void show(Comparable[] a){
       for (Comparable comparable : a) {
           System.out.print(comparable + " ");
       }
       System.out.println();
   };

   static boolean isSorted(Comparable[] a){
       for (int i = 0; i < a.length; i++) {
           if (less(a[i], a[i - 1])) return false;
       }
       return true;
   }

   static void swich(Comparable[] a, int i, int j){
       Comparable t = a[i];
       a[i] = a[j];
       a[j] = t;
   };
}