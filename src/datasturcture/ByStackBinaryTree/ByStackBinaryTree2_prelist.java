//�����ݽṹ��Java�棩����4�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��28��
//6.2.6   �������Ķ�������ʵ��
//������6��
//�Ա������������ȸ��������й�����������������м�BinaryTree_preCreate��
//���ÿ��Ҷ�ӽ����������Ƚ�㡣����ʹ��ջ��ʾ��ͼ��
package datasturcture.ByStackBinaryTree;//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��

public class ByStackBinaryTree2_prelist
{
    public static void main(String[] args) 
    {
                                                          //ͼ6.15��ʾ�������������������ȸ���������
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
//        String[] prelist = BinaryTreeLists.prelists[0];
        ByStackBinaryTree2<String> bitree = new ByStackBinaryTree2(prelist);
        ByStackBinaryTree2<String> bitree2 = new ByStackBinaryTree2(bitree);

//        bitree2.postorder();                        //����������������
//        ByStackBinaryTrees.leafAncestors(bitree);  //���ÿ��Ҷ�ӽ����������Ƚ�㣬���ջ
        bitree2.printGenList();                   //���������ʾ
        
/*        String key = "X";
        String find = bitree.search(key);                 //���ң��ǵݹ��㷨
        System.out.println("����"+key+"�����"+(find==null?"null":find));
 */ 
    }
}
/*
�������н�����£�10~11����㣬����ֵ����  
������������  G D B E H F C A //ͼ6.15
G�����Ƚ����SinglyList(D,B,A)
E�����Ƚ����SinglyList(C,A)
H�����Ƚ����SinglyList(F,C,A)
�������Ĺ�����ʾ��A(B(D(��,G),��),C(E,F(H,��)))

������������  R T S C B N O G L A                //abstractlong
R�����Ƚ����SinglyList(T,S,B,A)
C�����Ƚ����SinglyList(B,A)
N�����Ƚ����SinglyList(O,L,A)
G�����Ƚ����SinglyList(L,A)
�������Ĺ�����ʾ��A(B(S(��,T(R,��)),C),L(O(��,N),G))


�������������ǵݹ飩��  E R A L B M T O F U                //umbrellaFloat��ɡ
��������ÿ��Ҷ�ӽ����������Ƚ�㣺  
����E���������Ƚ����(R,B,M,U)
����A���������Ƚ����(L,B,M,U)
����T���������Ƚ����(O,F,U)

������������  C F G E D B M N L K R Q P O J I S H A 
�������Ĺ�����ʾ��A(B(C,D(��,E(F,G))),H(I(J(K(L(M,N),��),O(��,P(��,Q(R,��)))),��),S))

*/
//@author��Yeheya��2015-8-28
