//�����ݽṹ��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2015��10��27��
//��6.2.6   �������Ķ�������ʵ��
//9.  �������Ĳ�α���
//����  �Բ�α������й�����ȫ���������������Ĳ�α���
package datasturcture.ByStackBinaryTree;//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;
public class ByStackBinaryTree_Complete 
{
    public static void main(String[] args) 
    {
        String[] levellist = {"A","B","C","D","E","F","G","H"};//ͼ6.5
//      String[] levellist = {"A","M","B","U","L","N","C","E"};              //ambulance�Ȼ���
//      String[] levellist = {"H","E","L","I","C","O","P","T","R"};      //helicopterֱ���ɻ�

        BinaryTree<String> bitree = ByStackBinaryTree.createComplete(levellist);//�ɲ�α�������levellist������ȫ������
        //TODO:bitree.levelorder();                          //�������Ĳ�α���
    }
}
/*
�������н�����£�   
LinkedQueue(B,C)������B
LinkedQueue(C,D,E)������C
LinkedQueue(D,E,F,G)������D
LinkedQueue(E,F,G,H)������E
�������Ĳ�α������У�  A B C D E F G H 

�������Ĳ�α������У�  A M B U L N C E 
�������Ĳ�α������У�  H E L I C O P T R 

*/
//@author  Yeheya��2015-10-27
