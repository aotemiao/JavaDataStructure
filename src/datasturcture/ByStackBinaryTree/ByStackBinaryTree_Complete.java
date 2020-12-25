//《数据结构（Java版）（第5版）》，作者：叶核亚，2015年10月27日
//§6.2.6   二叉树的二叉链表实现
//9.  二叉树的层次遍历
//【】  以层次遍历序列构造完全二叉树；二叉树的层次遍历
package datasturcture.ByStackBinaryTree;//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;
public class ByStackBinaryTree_Complete 
{
    public static void main(String[] args) 
    {
        String[] levellist = {"A","B","C","D","E","F","G","H"};//图6.5
//      String[] levellist = {"A","M","B","U","L","N","C","E"};              //ambulance救护车
//      String[] levellist = {"H","E","L","I","C","O","P","T","R"};      //helicopter直升飞机

        BinaryTree<String> bitree = ByStackBinaryTree.createComplete(levellist);//由层次遍历序列levellist构造完全二叉树
        //TODO:bitree.levelorder();                          //二叉树的层次遍历
    }
}
/*
程序运行结果如下：   
LinkedQueue(B,C)，出队B
LinkedQueue(C,D,E)，出队C
LinkedQueue(D,E,F,G)，出队D
LinkedQueue(E,F,G,H)，出队E
二叉树的层次遍历序列：  A B C D E F G H 

二叉树的层次遍历序列：  A M B U L N C E 
二叉树的层次遍历序列：  H E L I C O P T R 

*/
//@author  Yeheya。2015-10-27
