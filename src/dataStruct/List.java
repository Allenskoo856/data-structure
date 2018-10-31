package dataStruct;


/**
 * List接口
 *
 * @author : Administrator
 * @create 2018-10-31 20:59
 */
public interface List<E> {

    int getSize();

    int getCapacity();

    boolean isEmpty();

    void addLast(E o);

    void insert(int index, E o);
}