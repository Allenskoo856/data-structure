package dataStruct.array;

import dataStruct.List;

import java.util.ArrayList;

import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * 自定义数组
 *
 * @author : Administrator
 * @create 2018-10-28 22:01
 */
public class Array<E> implements List {
    private Object[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量
     *
     * @return length
     */
    @Override
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     *
     * @return size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     *
     * @return Boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e int
     */
    @Override
    public void addLast(Object e) {
        insert(size, e);
    }

    /**
     * 向所有元素前添加一个新元素
     *
     * @param e int
     */
    public void addFirst(E e) {
        insert(0, e);
    }

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index 索引
     * @param e     新元素e
     */
    @Override
    public void insert(int index, Object e) {
        if (size == data.length) {
            resize(2 * data.length);
        }

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("out of boundary");
        }

        for (int i = size - 1; i >= size; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index  索引
     * @return E[data]
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return (E) data[index];
    }



    /**
     * 将数组空间的容量变成newCapacity大小
     *
     * @param newCapacity newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
