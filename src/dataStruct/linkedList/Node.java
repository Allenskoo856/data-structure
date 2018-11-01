package dataStruct.linkedList;

/**
 * @author : Administrator
 * @create 2018-11-01 17:37
 */
public class Node<E> {
    protected E e;
    protected Node next;

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }

    public Node(E e) {
        this(e, null);
    }

    public Node() {
        this(null, null);
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
