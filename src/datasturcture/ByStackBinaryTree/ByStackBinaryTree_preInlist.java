//�����ݽṹ��Java�棩����4�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��28��
//6.2.6   �������Ķ�������ʵ��
//������6�����ȸ����к��и����й��������
//��ʵ����6-3������6����BinaryTree<T>�����������ķǵݹ��㷨��ʹ��ջ����̬����������ʹ��ջ�ı仯ͼ��
//����
package datasturcture.ByStackBinaryTree;//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��

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
//      String[] inlist = {"S","R","T","B","C","A","O","N","L","G"}; //����������/�и���������
      
      String[] prelist = {"U","M","B","R","E","L","A", "F","O","T"};//umbrellaFloat��ɡ
      String[] inlist = {"M","E","R","B","A","L","U", "F","T","O"}; //����������/�и���������

        ByStackBinaryTree<String> bitree = new ByStackBinaryTreeExercise<String>(prelist, inlist);
       
        //�Ա������������ȸ��������й�����������������м�BinaryTree_preCreate��
//        BinaryTree<String> bitree = new BinaryTree<String>(BinaryTree_preCreate.prelist[0]);
        ByStackBinaryTree<String> bitree = ByStackBinaryTreeByStack.createPreOrder(BinaryTree_preCreate.prelist[0]);
        String key = "X";
        BinaryNode<String> find = BinaryTreeByStack.search(bitree, key); //���ң��ǵݹ��㷨
        System.out.println("����"+key+"�����"+(find==null?"null":find.data.toString()));

        ByStackBinaryTree<String> bitree = new ByStackBinaryTreeExercise<String>(prelist, inlist);
        ByStackBinaryTree.postorder(bitree);               //����������������
        ByStackBinaryTree.leafAncestors(bitree);
*/    }
}
/*
�������н�����£�10~11����㣬����ֵ����  
�ȸ�����������ǵݹ飩��  ����R��ջ��(T,B,A)                //abstractlong
����C��ջ��(A)
����N��ջ��(L)
����G��ջ��()
����X�����null

*/
//@author��Yeheya��2015-8-28
