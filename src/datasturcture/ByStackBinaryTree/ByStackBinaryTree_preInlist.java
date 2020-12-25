//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年8月28日
//6.2.6   二叉树的二叉链表实现
//【试题6】以先根序列和中根序列构造二叉树
//【实验题6-3，试题6】对BinaryTree<T>二叉树操作的非递归算法，使用栈，静态方法。画出使用栈的变化图。
//？？
package datasturcture.ByStackBinaryTree;//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;

public class ByStackBinaryTree_preInlist 
{
    public static void main(String[] args) 
    {
        /*//        String[] prelist = {"A","B","S","T","R","C","L","O","N","G"};//abstractlong
//      String[] inlist = {"S","R","T","B","C","A","O","N","L","G"}; //二叉树的先/中根遍历序列
      
      String[] prelist = {"U","M","B","R","E","L","A", "F","O","T"};//umbrellaFloat雨伞
      String[] inlist = {"M","E","R","B","A","L","U", "F","T","O"}; //二叉树的先/中根遍历序列

        ByStackBinaryTree<String> bitree = new ByStackBinaryTreeExercise<String>(prelist, inlist);
       
        //以标明空子树的先根遍历序列构造二叉树，遍历序列见BinaryTree_preCreate。
//        BinaryTree<String> bitree = new BinaryTree<String>(BinaryTree_preCreate.prelist[0]);
        ByStackBinaryTree<String> bitree = ByStackBinaryTreeByStack.createPreOrder(BinaryTree_preCreate.prelist[0]);
        String key = "X";
        BinaryNode<String> find = BinaryTreeByStack.search(bitree, key); //查找，非递归算法
        System.out.println("查找"+key+"，结果"+(find==null?"null":find.data.toString()));

        ByStackBinaryTree<String> bitree = new ByStackBinaryTreeExercise<String>(prelist, inlist);
        ByStackBinaryTree.postorder(bitree);               //后根次序遍历二叉树
        ByStackBinaryTree.leafAncestors(bitree);
*/    }
}
/*
程序运行结果如下，10~11个结点，按根值排序。  
先根次序遍历（非递归）：  访问R，栈是(T,B,A)                //abstractlong
访问C，栈是(A)
访问N，栈是(L)
访问G，栈是()
查找X，结果null

*/
//@author：Yeheya。2015-8-28
