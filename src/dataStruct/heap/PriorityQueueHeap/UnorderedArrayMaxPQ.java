package dataStruct.heap.PriorityQueueHeap;

import edu.princeton.cs.algs4.StdOut;

/**
 * 无序数组实现优先队列
 *
 * @author : Administrator
 * @create 2019-01-07 20:10
 */
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int num;

    public UnorderedArrayMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
        num = 0;
    }

    public void insert(Key x) {
        pq[num++] =x;
    }


    public Key delMax() {
        int max = 0;
        for (int i = 0; i < num; i++) {
            if (less(max, i)) max = i;
        }
        exch(max, num - 1);
        num--;
        return pq[num];
    }


    public boolean isEmpty() {
        return num == 0;
    }


    public Comparable max() {
        return null;
    }


    public int size() {
        return num;
    }

    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
    }
}
