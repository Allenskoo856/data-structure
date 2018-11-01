package dataStruct.array;

import dataStruct.List;

/**
 * 自定义数组
 *
 * @author : Administrator
 * @create 2018-10-28 22:01
 */
public class Array<E> implements List<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
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
    public void addLast(E e) {
        insert(size, e);
    }

    /**
     * 向所有元素前添加一个新元素
     *
     * @param e int
     */
    @Override
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
    public void insert(int index, E e) {
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
     *
     * @param index 索引
     * @return E[data]
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return (E) data[index];
    }

    /**
     * Get last element
     *
     * @return E
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * get getFirst
     *
     * @return E
     */
    public E getFirst() {
        return get(0);
    }


    @Override
    public void replace(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    @Override
    public void removeElement(E e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     *
     * @return E
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return E
     */
    public E removeLast() {
        return remove(size - 1);
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
