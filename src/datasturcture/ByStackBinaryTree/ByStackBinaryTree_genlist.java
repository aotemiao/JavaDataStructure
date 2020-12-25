//《数据结构（Java版）（第4版）》，作者：叶核亚，2015年10月25日
//§6.2.6   二叉树的二叉链表实现
//7.  二叉树的广义表表示
//【例6.2】 二叉树的广义表表示。 
package datasturcture.ByStackBinaryTree;//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;

public class ByStackBinaryTree_genlist
{    
    public static void main(String args[])
    {
//        String genlist = "A(B,C)";
        String genlist = "A(B(D(^,G),^),C(E,F(H,^)))";  //图6.18所示二叉树的广义表表示
//        String genlist = "AA(BB(DDD(^,GGG),^),CCC(EE,FF(HH,^)))";  
//        genlist = "AAA(BBBB,CCCC(D(F,G(J,^)),E(H(K,L),I(^,MMMMM))))";
        
        //在中序线索二叉树中求父母结点
//        String genlist = "A(B(C,D(∧,E(F,G))),H(I(J(K(L(M,N),∧),O(∧,P(∧,Q(R,∧)))),∧),S))";

        ByStackBinaryTree<String> bitree = ByStackBinaryTrees.createByGenList(genlist);               
        bitree.printGenList();                             //输出二叉树的广义表表示字符串 
        ByStackBinaryTrees.leafToRoot(bitree);
        //习题6
//        System.out.println("是否完全二叉树？  "+bitree.isCompleteBinaryTree());  
    }
}
/*
程序运行结果如下：
二叉树的广义表表示：A(B,C)
二叉树的广义表表示：AA(BB(DDD(∧,GGG),∧),CCC(EE,FF(HH,∧)))
二叉树的广义表表示：AAA(BBBB,CCCC(D(F,G(J,∧)),E(H(K,L),I(∧,MMMMM))))
二叉树的广义表表示：A(B(C,D(∧,E(F,G))),H(I(J(K(L(M,N),∧),O(∧,P(∧,Q(R,∧)))),∧),S))

二叉树的广义表表示：A(B(D(∧,G),∧),C(E,F(H,∧)))
G的祖先结点是LinkedStack (D,B,A)
E的祖先结点是LinkedStack (C,A)
H的祖先结点是LinkedStack (F,C,A)
二叉树的广义表表示：AA(BB(DD(^,G),^),C(E,F(H,^)))
是否完全二叉树？  false

二叉树的广义表表示：A(B,C)
是否完全二叉树？  true

二叉树的广义表表示：∧
是否完全二叉树？  true

二叉树的广义表表示：A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M))))
是否完全二叉树？  false


二叉树的广义表表示：A(B(C,D(∧,E(F,G))),H(I(J(K(L(M,N),∧),O(∧,P(∧,Q(R,∧)))),∧),S))



*/

//@author：Yeheya。2015-11-2
