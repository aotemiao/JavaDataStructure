//《数据结构（Java版）（第4版）试题库》，作者：叶核亚，2015年8月28日
//6.2.6   二叉树的二叉链表实现
//【试题6】
//以标明空子树的先根遍历序列构造二叉树，遍历序列见BinaryTree_preCreate。
//输出每个叶子结点的所有祖先结点。画出使用栈的示意图。
package datasturcture.ByStackBinaryTree;//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。

public class ByStackBinaryTree2_prelist
{
    public static void main(String[] args) 
    {
                                                          //图6.15所示二叉树标明空子树的先根遍历序列
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
//        String[] prelist = BinaryTreeLists.prelists[0];
        ByStackBinaryTree2<String> bitree = new ByStackBinaryTree2(prelist);
        ByStackBinaryTree2<String> bitree2 = new ByStackBinaryTree2(bitree);

//        bitree2.postorder();                        //后根次序遍历二叉树
//        ByStackBinaryTrees.leafAncestors(bitree);  //输出每个叶子结点的所有祖先结点，输出栈
        bitree2.printGenList();                   //输出广义表表示
        
/*        String key = "X";
        String find = bitree.search(key);                 //查找，非递归算法
        System.out.println("查找"+key+"，结果"+(find==null?"null":find));
 */ 
    }
}
/*
程序运行结果如下，10~11个结点，按根值排序。  
后根次序遍历：  G D B E H F C A //图6.15
G的祖先结点是SinglyList(D,B,A)
E的祖先结点是SinglyList(C,A)
H的祖先结点是SinglyList(F,C,A)
二叉树的广义表表示：A(B(D(∧,G),∧),C(E,F(H,∧)))

后根次序遍历：  R T S C B N O G L A                //abstractlong
R的祖先结点是SinglyList(T,S,B,A)
C的祖先结点是SinglyList(B,A)
N的祖先结点是SinglyList(O,L,A)
G的祖先结点是SinglyList(L,A)
二叉树的广义表表示：A(B(S(∧,T(R,∧)),C),L(O(∧,N),G))


后根次序遍历（非递归）：  E R A L B M T O F U                //umbrellaFloat雨伞
二叉树中每个叶子结点的所有祖先结点：  
访问E，所有祖先结点是(R,B,M,U)
访问A，所有祖先结点是(L,B,M,U)
访问T，所有祖先结点是(O,F,U)

后根次序遍历：  C F G E D B M N L K R Q P O J I S H A 
二叉树的广义表表示：A(B(C,D(∧,E(F,G))),H(I(J(K(L(M,N),∧),O(∧,P(∧,Q(R,∧)))),∧),S))

*/
//@author：Yeheya。2015-8-28
