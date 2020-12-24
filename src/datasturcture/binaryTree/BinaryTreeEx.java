package datasturcture.binaryTree;

import static datasturcture.binaryTree.BinaryTree.createComplete;

public class BinaryTreeEx extends BinaryTreeIsSorted {
    public static void main(String[] args) {
        String test[] = {"0", "1", "2", "3", "4", "5", "6"};
        BinaryTree testTree1 = createComplete(test);
        System.out.println(testTree1.toString());

        System.out.println("----------------");
        String prelist[] = {"6", "2", "1", "^", "^", "4", "3", "^", "^", "5", "^", "^", "7", "^", "9", "8", "^", "^", "^"};
        BinaryTree testtree2 = new BinaryTree(prelist);
        testtree2.inorderTraverse();
        System.out.println("isSorted(testtree2)="+isSorted(testtree2));


    }
}
