package dataStruct.tree;


/**
 * @author : Administrator
 * @create 2018-11-04 16:09
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        add(root, e);
    }

    /**
     * 以node为根的二分搜索树中插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根
     *
     * @param node node
     * @param e   e
     * @return  changeNode
     */
    private TreeNode add(TreeNode<E> node, E e) {
        if (node == null) {
            size++;
            return new TreeNode<>(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(TreeNode<E> node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {

        }
    }

}
