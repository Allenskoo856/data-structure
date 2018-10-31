package dataStruct;

import java.util.ArrayList;

/**
 * List接口
 *
 * @author : Administrator
 * @create 2018-10-31 20:59
 */
public interface List {

    int getSize();

    int getCapacity();

    boolean isEmpty();


    void addLast(Object o);


    void insert(int index, Object o);
}