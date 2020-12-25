//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2015��10��25��
//��6.2.6   �������Ķ�������ʵ��
//7.  �������Ĺ�����ʾ
//����6.2�� �������Ĺ�����ʾ�� 
package datasturcture.ByStackBinaryTree;//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��

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
        String genlist = "A(B(D(^,G),^),C(E,F(H,^)))";  //ͼ6.18��ʾ�������Ĺ�����ʾ
//        String genlist = "AA(BB(DDD(^,GGG),^),CCC(EE,FF(HH,^)))";  
//        genlist = "AAA(BBBB,CCCC(D(F,G(J,^)),E(H(K,L),I(^,MMMMM))))";
        
        //��������������������ĸ���
//        String genlist = "A(B(C,D(��,E(F,G))),H(I(J(K(L(M,N),��),O(��,P(��,Q(R,��)))),��),S))";

        ByStackBinaryTree<String> bitree = ByStackBinaryTrees.createByGenList(genlist);               
        bitree.printGenList();                             //����������Ĺ�����ʾ�ַ��� 
        ByStackBinaryTrees.leafToRoot(bitree);
        //ϰ��6
//        System.out.println("�Ƿ���ȫ��������  "+bitree.isCompleteBinaryTree());  
    }
}
/*
�������н�����£�
�������Ĺ�����ʾ��A(B,C)
�������Ĺ�����ʾ��AA(BB(DDD(��,GGG),��),CCC(EE,FF(HH,��)))
�������Ĺ�����ʾ��AAA(BBBB,CCCC(D(F,G(J,��)),E(H(K,L),I(��,MMMMM))))
�������Ĺ�����ʾ��A(B(C,D(��,E(F,G))),H(I(J(K(L(M,N),��),O(��,P(��,Q(R,��)))),��),S))

�������Ĺ�����ʾ��A(B(D(��,G),��),C(E,F(H,��)))
G�����Ƚ����LinkedStack (D,B,A)
E�����Ƚ����LinkedStack (C,A)
H�����Ƚ����LinkedStack (F,C,A)
�������Ĺ�����ʾ��AA(BB(DD(^,G),^),C(E,F(H,^)))
�Ƿ���ȫ��������  false

�������Ĺ�����ʾ��A(B,C)
�Ƿ���ȫ��������  true

�������Ĺ�����ʾ����
�Ƿ���ȫ��������  true

�������Ĺ�����ʾ��A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M))))
�Ƿ���ȫ��������  false


�������Ĺ�����ʾ��A(B(C,D(��,E(F,G))),H(I(J(K(L(M,N),��),O(��,P(��,Q(R,��)))),��),S))



*/

//@author��Yeheya��2015-11-2
