package Junit.testCase;

import dataStruct.linkedList.LinkedList;
import org.junit.Test;

/**
 * @author : Administrator
 * @create 2018-11-01 20:45
 */
public class TestLinkedList {


    @Test
    public void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.insert(2, 666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println(linkedList.indexOf(1));
        linkedList.removeElement(1);
        System.out.println(linkedList);
    }
}
