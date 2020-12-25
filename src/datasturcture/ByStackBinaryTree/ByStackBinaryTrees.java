//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��10��25��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ����̬������
package datasturcture.ByStackBinaryTree;//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;

public class ByStackBinaryTrees                                    //Ϊ�ض����������Ӿ�̬����
{
    //���ÿ��Ҷ�ӽ������Ƚ�㣨������·������
    //�����������������ķǵݹ��㷨���㷨ʹ��front��סp��ǰ�����
    public static<T> void leafToRoot(BinaryTree<T> bitree)
    {
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p=bitree.root, front=null;
        while (p!=null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                stack.push(p);                             //p�����ջ
                p=p.left;                                  //����������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
                p=stack.peek();                            //������������p��㣬p��㲻��ջ
                if (p.right!=null && p.right!=front)       //p���Һ��ӣ����Һ���û�����ʹ�
                    p = p.right;                           //����������
                else
                {
                    p=stack.pop();                         //������������p��㣬p����ջ
                    if (p.isLeaf())
                        System.out.println(p.data+"�����Ƚ����"+stack.toString());
                    front = p;                             //frontָ��p�ں�����������µ�ǰ�����
                    p=null;                                //p�����Ϸ��ظ�ĸ���
                }
            }
        System.out.println();
    }  
    
    //���������
    private static int i=0;
    //����genlist���ӵ�i���ַ���ʼ���Ӵ�����(,)�ַ��ָ�ı�i���Ӵ����¸��ַ�
    private static String sub(String genlist)
    {
        int end=i;
        char ch=' ';
        while (end<genlist.length() && "(,)".indexOf(genlist.charAt(end))==-1)
            end++;
        String str = genlist.substring(i, end);  //��ô�i��end-1���Ӵ������
        i=end;                                   //�ı�i���Ӵ����¸��ַ�
//        System.out.println("sub="+str+",i="+i);
        return str;        
    }

    //�����Թ�����ʾ�ַ���genlist����Ķ��������ȸ�������ķǵݹ��㷨��ʹ��ջ��
    //����boolean����leftChild���ִ����Ľ����p����/�Һ��ӣ�Ĭ���������
    public static ByStackBinaryTree<String> createByGenList(String genlist)
    {
        ByStackBinaryTree<String> bitree = new ByStackBinaryTree<String>();
        if (genlist.length()==0 || genlist.charAt(0)=='^')
            return bitree;
        i=0;
        Stack<BinaryNode<String>> stack = new LinkedStack<BinaryNode<String>>();//ջ
        bitree.root = new BinaryNode<String>(sub(genlist));//��������㣬ֵΪ�ӵ�i���ַ���ʼ���Ӵ����ı�i���Ӵ����¸��ַ�
        BinaryNode<String> p = bitree.root;
        boolean leftChild=true;                  //֮�󽫴���p������
        while (i<genlist.length())
        {
            char ch=genlist.charAt(i);
            switch (ch)
            {
                case'(':
                    stack.push(p);               //�������Ľ����ջ��Ҷ�ӽ��û��ջ
                    leftChild=true;              //֮�󽫴���p������
                    i++;  break;
                    
               case',':
                    p = stack.pop();             //����ջ�������������ظ�ĸ�����Ƚ��p
                    leftChild = false;           //֮�󽫴���p���Һ���
                    i++;  break;

               case '^': case')':
                    i++;  break;

               default:     //ʶ��ӵ�i���ַ���ʼ���Ӵ���ΪԪ�أ��ı�i���Ӵ����¸��ַ�
                    if (leftChild)
                    {
                        p.left = new BinaryNode<String>(sub(genlist));//����p�����ӽ��
                        p = p.left;                                 //����p��������
                    }
                    else
                    {
                        p.right = new BinaryNode<String>(sub(genlist));//����p�Һ��ӽ��
                        p = p.right;                                 //����p������
                    }
            }
        }
        return bitree;
    }

    
}
/*
*/
