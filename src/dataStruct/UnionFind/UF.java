package dataStruct.UnionFind;

/**
 * @author : Administrator
 * @create 2018-11-26 21:11
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

    int find(int p);

}