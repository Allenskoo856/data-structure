package dataStruct.heap.PriorityQueueHeap;

/**
 * @author : Administrator
 * @create 2019-01-07 19:52
 */
public interface MaxPQ<Key extends Comparable<Key>> {

    void insert(Key v);

    Key delMax();

    boolean isEmpty();

    Key max();

    int size();
}