package dataStruct;

/**
 * @author : Administrator
 * @create 2018-11-01 13:59
 */
public interface Queue <E>{

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}