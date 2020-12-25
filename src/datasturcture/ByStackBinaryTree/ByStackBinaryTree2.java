//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��
package datasturcture.ByStackBinaryTree;//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;
//�������࣬��������洢�� �ǵݹ��㷨��ʹ��ջ��
public class ByStackBinaryTree2<T> extends BinaryTree<T>
{
    public ByStackBinaryTree2()                   //����ն�����
    {
         super();
    }

    //��3�����������
    //�Ա������������ȸ����й���һ�ö�������prelist����ָ���ȸ��������С�
    //�ȸ���������ķǵݹ��㷨��ʹ��ջ������boolean����leftChild���ִ����Ľ����p����/�Һ��ӣ�Ĭ���������
    public ByStackBinaryTree2(T[] prelist)
    {  
        this();                                            //����ն�����
        if (prelist.length==0) 
            return;
        this.root = new BinaryNode<T>(prelist[0]);         //���������
        Stack<BinaryNode<T>> stack = new SeqStack<BinaryNode<T>>(); //��ջ
        stack.push(this.root);                             //������ջ
        BinaryNode<T> p = this.root;
        boolean leftChild=true;                  //leftChild���ֽ�����p����/�Һ��ӣ�Ĭ���������
        for (int i=1; i<prelist.length; i++)
            if (prelist[i]!=null)
            {
                if (leftChild)
                {            
                    p.left = new BinaryNode<T>(prelist[i]);//����p�����ӽ��
                    p=p.left;                              //����������
                }
                else
                {
                    p.right = new BinaryNode<T>(prelist[i]);//����p���Һ��ӽ��
                    p=p.right;                              //����������
                }
                stack.push(p);                              //�մ����Ľ���ջ
                leftChild = true;                           //֮�󽫴���p������
            }
            else                                 //����'^'
            {
                p = stack.pop();                 //����ջ�������������ظ�ĸ�����Ƚ��p
                leftChild = false;               //֮�󽫴���p���Һ���
            }
    }
    //@author  Yeheya��2016-12-29���޸Ĳ��ԣ���ջ�󣬴����Һ��ӽ�㣬δ�ɹ���

    
    //��ʵ����6-3��������������ǵݹ��㷨��ʹ��ջ
//??    public ByStackBinaryTree(BinaryTree<T> tree)

    //�ȸ���������㷨������leftChild���ִ����Ľ����q����/�Һ��ӣ�Ĭ���������
//    public static<T> ByStackBinaryTree<T> copy(BinaryTree<T> bitree)
    public ByStackBinaryTree2(BinaryTree<T> bitree)
    {
        this();
//        ByStackBinaryTree<T> copytree = new ByStackBinaryTree<T>();
//        if (bitree.isEmpty()) 
//            return copytree;
        Stack<BinaryNode<T>> stack1 = new SeqStack<BinaryNode<T>>();    //ջ
        Stack<BinaryNode<T>> stack2 = new LinkedStack<BinaryNode<T>>(); //ջ
        this.root = new BinaryNode<T>(bitree.root.data);  //���������
      BinaryNode<T> p=bitree.root, q=this.root;
        while(p!=null || !stack1.isEmpty())     //ʹ��p����bitree������
        {
            if(p!=null)
            {      //����p��㣬����q����/�Һ��ӽ�㣨ֵΪp.data�����������ջ��������           
                stack1.push(p);
                stack2.push(q);
                p = p.left;                      //����p��������
                if(p!=null)
                {            
                    q.left = new BinaryNode<T>(p.data);
                    q = q.left;
                }
            }
            else       //�����������꣬����ջ�����ظ�ĸ�����Ƚ�㣬�ٽ���p��������                                 
            {
                p = stack1.pop(); 
                q = stack2.pop();
                p = p.right;                     //����p��������
                if(p!=null)
                {
                    q.right = new BinaryNode<T>(p.data);
                    q=q.right;
                }
            }
        }
    }
    //@author  Yeheya��2020-12-22���޸Ĳ��ԣ���ջ�󣬴����Һ��ӽ�㣬�ɹ���
}
//2020-12-22