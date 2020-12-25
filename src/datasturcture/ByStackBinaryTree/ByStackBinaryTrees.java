//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年10月25日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈，静态方法。
package datasturcture.ByStackBinaryTree;//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;

public class ByStackBinaryTrees                                    //为特定二叉树增加静态方法
{
    //输出每个叶子结点的祖先结点（到根的路径）。
    //后根次序遍历二叉树的非递归算法，算法使用front记住p的前驱结点
    public static<T> void leafToRoot(BinaryTree<T> bitree)
    {
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p=bitree.root, front=null;
        while (p!=null || !stack.isEmpty())                //p非空或栈非空时
            if (p!=null)
            {
                stack.push(p);                             //p结点入栈
                p=p.left;                                  //进入左子树
            }
            else                                           //p为空且栈非空时
            {
                p=stack.peek();                            //从左子树返回p结点，p结点不出栈
                if (p.right!=null && p.right!=front)       //p有右孩子，且右孩子没被访问过
                    p = p.right;                           //进入右子树
                else
                {
                    p=stack.pop();                         //从右子树返回p结点，p结点出栈
                    if (p.isLeaf())
                        System.out.println(p.data+"的祖先结点是"+stack.toString());
                    front = p;                             //front指向p在后根遍历次序下的前驱结点
                    p=null;                                //p再向上返回父母结点
                }
            }
        System.out.println();
    }  
    
    //构造二叉树
    private static int i=0;
    //返回genlist串从第i个字符开始的子串，以(,)字符分割；改变i到子串的下个字符
    private static String sub(String genlist)
    {
        int end=i;
        char ch=' ';
        while (end<genlist.length() && "(,)".indexOf(genlist.charAt(end))==-1)
            end++;
        String str = genlist.substring(i, end);  //获得从i～end-1的子串，深拷贝
        i=end;                                   //改变i到子串的下个字符
//        System.out.println("sub="+str+",i="+i);
        return str;        
    }

    //返回以广义表表示字符串genlist构造的二叉树。先根次序构造的非递归算法，使用栈，
    //声明boolean变量leftChild区分创建的结点是p的左/右孩子，默认先左后右
    public static ByStackBinaryTree<String> createByGenList(String genlist)
    {
        ByStackBinaryTree<String> bitree = new ByStackBinaryTree<String>();
        if (genlist.length()==0 || genlist.charAt(0)=='^')
            return bitree;
        i=0;
        Stack<BinaryNode<String>> stack = new LinkedStack<BinaryNode<String>>();//栈
        bitree.root = new BinaryNode<String>(sub(genlist));//创建根结点，值为从第i个字符开始的子串，改变i到子串的下个字符
        BinaryNode<String> p = bitree.root;
        boolean leftChild=true;                  //之后将创建p的左孩子
        while (i<genlist.length())
        {
            char ch=genlist.charAt(i);
            switch (ch)
            {
                case'(':
                    stack.push(p);               //有子树的结点入栈，叶子结点没入栈
                    leftChild=true;              //之后将创建p的左孩子
                    i++;  break;
                    
               case',':
                    p = stack.pop();             //结点出栈，从左子树返回父母或祖先结点p
                    leftChild = false;           //之后将创建p的右孩子
                    i++;  break;

               case '^': case')':
                    i++;  break;

               default:     //识别从第i个字符开始的子串作为元素，改变i到子串的下个字符
                    if (leftChild)
                    {
                        p.left = new BinaryNode<String>(sub(genlist));//创建p的左孩子结点
                        p = p.left;                                 //进入p的左子树
                    }
                    else
                    {
                        p.right = new BinaryNode<String>(sub(genlist));//创建p右孩子结点
                        p = p.right;                                 //进入p右子树
                    }
            }
        }
        return bitree;
    }

    
}
/*
*/
