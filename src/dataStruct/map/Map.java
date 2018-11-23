package dataStruct.map;

/**
 * @author : Administrator
 * @create 2018-11-23 13:53
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();

}