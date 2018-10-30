package dataStruct.array;

/**
 * 自定义数组
 *
 * @author : Administrator
 * @create 2018-10-28 22:01
 */
public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
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
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     *
     * @return Boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e int
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 向所有元素前添加一个新元素
     *
     * @param e int
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index 索引
     * @param e     新元素e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i >= size; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
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
