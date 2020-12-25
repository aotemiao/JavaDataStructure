package datasturcture.binaryTree;

/**
 * @author aotemiao
 * @date 2020/12/10 14:21
 */
//import java.util.Comparator

public class BinaryTreeIsSorted {
    private static BinaryNode<?> front;

    static <T extends Comparable<? super T>> boolean isSorted(BinaryTree<T> tree) {
        front = null;
        return (isSorted(tree.root));
    }

    private static <T extends Comparable<? super T>> boolean isSorted(BinaryNode<T> p) {
        if (p == null) return true;
        if (!isSorted(p.left)) return false;
        if (front != null && p.data.compareTo((T) front.data) < 0) return false;
        front = p;
        return isSorted(p.right);
    }

}
