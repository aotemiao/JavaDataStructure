//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。
package datasturcture.ByStackBinaryTree;//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;
//二叉树类，二叉链表存储； 非递归算法，使用栈。
public class ByStackBinaryTree2<T> extends BinaryTree<T>
{
    public ByStackBinaryTree2()                   //构造空二叉树
    {
         super();
    }

    //（3）构造二叉树
    //以标明空子树的先根序列构造一棵二叉树，prelist数组指定先根遍历序列。
    //先根次序遍历的非递归算法，使用栈，声明boolean变量leftChild区分创建的结点是p的左/右孩子，默认先左后右
    public ByStackBinaryTree2(T[] prelist)
    {  
        this();                                            //构造空二叉树
        if (prelist.length==0) 
            return;
        this.root = new BinaryNode<T>(prelist[0]);         //创建根结点
        Stack<BinaryNode<T>> stack = new SeqStack<BinaryNode<T>>(); //空栈
        stack.push(this.root);                             //根结点进栈
        BinaryNode<T> p = this.root;
        boolean leftChild=true;                  //leftChild区分将创建p的左/右孩子，默认先左后右
        for (int i=1; i<prelist.length; i++)
            if (prelist[i]!=null)
            {
                if (leftChild)
                {            
                    p.left = new BinaryNode<T>(prelist[i]);//创建p的左孩子结点
                    p=p.left;                              //进入左子树
                }
                else
                {
                    p.right = new BinaryNode<T>(prelist[i]);//创建p的右孩子结点
                    p=p.right;                              //进入右子树
                }
                stack.push(p);                              //刚创建的结点进栈
                leftChild = true;                           //之后将创建p的左孩子
            }
            else                                 //遇到'^'
            {
                p = stack.pop();                 //结点出栈，从左子树返回父母或祖先结点p
                leftChild = false;               //之后将创建p的右孩子
            }
    }
    //@author  Yeheya。2016-12-29，修改测试，出栈后，创建右孩子结点，未成功。

    
    //【实验题6-3】二叉树深拷贝，非递归算法，使用栈
//??    public ByStackBinaryTree(BinaryTree<T> tree)

    //先根次序遍历算法，声明leftChild区分创建的结点是q的左/右孩子，默认先左后右
//    public static<T> ByStackBinaryTree<T> copy(BinaryTree<T> bitree)
    public ByStackBinaryTree2(BinaryTree<T> bitree)
    {
        this();
//        ByStackBinaryTree<T> copytree = new ByStackBinaryTree<T>();
//        if (bitree.isEmpty()) 
//            return copytree;
        Stack<BinaryNode<T>> stack1 = new SeqStack<BinaryNode<T>>();    //栈
        Stack<BinaryNode<T>> stack2 = new LinkedStack<BinaryNode<T>>(); //栈
        this.root = new BinaryNode<T>(bitree.root.data);  //创建根结点
      BinaryNode<T> p=bitree.root, q=this.root;
        while(p!=null || !stack1.isEmpty())     //使用p遍历bitree二叉树
        {
            if(p!=null)
            {      //到达p结点，创建q的左/右孩子结点（值为p.data），两结点入栈，再向左           
                stack1.push(p);
                stack2.push(q);
                p = p.left;                      //进入p的左子树
                if(p!=null)
                {            
                    q.left = new BinaryNode<T>(p.data);
                    q = q.left;
                }
            }
            else       //左子树遍历完，结点出栈，返回父母或祖先结点，再进入p的右子树                                 
            {
                p = stack1.pop(); 
                q = stack2.pop();
                p = p.right;                     //进入p的右子树
                if(p!=null)
                {
                    q.right = new BinaryNode<T>(p.data);
                    q=q.right;
                }
            }
        }
    }
    //@author  Yeheya。2020-12-22，修改测试，出栈后，创建右孩子结点，成功。
}
//2020-12-22