package dataStruct.set;

/**
 * @author : Administrator
 * @create 2018-11-22 21:00
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}