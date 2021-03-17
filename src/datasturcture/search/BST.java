package datasturcture.search;


import com.sun.jdi.Value;

import java.security.Key;

/**
 * @author aotemiao
 * @date 2021/3/16 20:45
 */
public class BST<key extends Comparable<key>> {
    private Node root;

    private class Node<T> {//todo:内部类？
        private Key key;
        private Value val;
        private Node left, right;
        private int N;  //以该结点为根的字数的结点总数

        public Node(Key key, Value val, int Node) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

}