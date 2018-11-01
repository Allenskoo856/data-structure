package dataStruct;


/**
 * List接口
 *
 * @author : Administrator
 * @create 2018-10-31 20:59
 */
public interface List<E> {

    int getSize();

    boolean isEmpty();

    boolean contains(E e);

    int indexOf(E e);

    E remove(int index);

    void removeElement(E e);

    void addLast(E o);

    void addFirst(E o);

    E get(int index);

    void replace(int i, E e);

    void insert(int index, E o);
}