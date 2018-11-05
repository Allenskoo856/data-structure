package dataStruct.tree;

/**
 * @author : Administrator
 * @create 2018-11-04 15:55
 */
public class TreeNode<E> {
    E e;
    TreeNode left;
    TreeNode right;

    public TreeNode(E e) {
        this.e = e;
        left = null;
        right = null;
    }
}
