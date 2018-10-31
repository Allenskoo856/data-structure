package dataStruct;

/**
 * @author : Administrator
 * @create 2018-10-31 22:18
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}