package dataStruct.linkedList;

import dataStruct.List;

/**
 * @author : Administrator
 * @create 2018-11-01 17:33
 */
public class LinkedList<E> implements List<E> {
    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<E>();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        Node cur = dummyHead;
        while (cur != null) {
            if (cur.e == e) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        Node cur = dummyHead;
        int index = -1;
        while (cur.e != e) {
            cur = cur.next;
            index++;
        }
        return index;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return (E) retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void removeElement(E e) {
        Node cur = dummyHead;
        int index = -1;
        while (cur.e != e) {
            cur = cur.next;
            index++;
        }
        remove(index);
    }

    @Override
    public void addLast(E o) {
        insert(size, o);
    }

    @Override
    public void addFirst(E o) {
        insert(0, o);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.e;
    }


    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    @Override
    public void replace(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    @Override
    public void insert(int index, E o) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node<E> node = new Node<>(o);
        node.next = pre.next;
        pre.next = node;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
