package Junit.testCase;

import dataStruct.tree.BinarySearchTree;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author : Administrator
 * @create 2018-11-22 11:33
 */
public class TestBST {

    @Test
    public void assertBSTPrint() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] numbs = {5, 8, 3, 2, 90};
        for (int num : numbs) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        /*System.out.println(bst);*/
        bst.inOrder();
        System.out.println();

    }
}
