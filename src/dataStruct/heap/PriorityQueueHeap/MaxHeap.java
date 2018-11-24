package dataStruct.heap.PriorityQueueHeap;

import dataStruct.array.Array;

/**
 * @author : Administrator
 * @create 2018-11-23 21:08
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 传入一个数组，进行数组排序建堆的过程；
     *
     * @param arr arr
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index 索引
     * @return int
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index 索引
     * @return int
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index 索引
     * @return int
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        shitUp(data.getSize() - 1);
    }


    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 交互节点后，节点下浮、实现堆的性质
     *
     * @param k
     */
    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 向堆中添加元素, 并且维护堆的稳定性
     *
     * @param i 堆中元素
     */
    private void shitUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     *
     * @param e e
     * @return  E
     */
    public E replace(E e) {
        E ret = findMax();
        data.insert(0, e);
        siftDown(0);
        return ret;
    }
}
