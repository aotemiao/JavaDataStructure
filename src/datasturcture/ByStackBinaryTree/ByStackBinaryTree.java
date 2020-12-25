package datasturcture.ByStackBinaryTree;//�����ݽṹ��Java�棩����5�棩����⡷�����ߣ�Ҷ���ǣ�2015��8��10��
//��6.2.6   �������Ķ�������ʵ��
//��ʵ����6-4�������������ķǵݹ��㷨��ʹ��ջ��

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;

//�������࣬��������洢�� �ǵݹ��㷨��ʹ��ջ��
public class ByStackBinaryTree<T> extends BinaryTree<T>
{
    public ByStackBinaryTree()                   //����ն�����
    {
         super();
    }

    //��1���ȸ���������㷨�ķǵݹ��㷨��ʹ��ջ
    //�����״γ��ֹؼ���ΪkeyԪ�أ���δ�ҵ�����null
    public T search(T key)
    {
        System.out.print("�ȸ����������  ");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //ջ
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())      //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                if (key.equals(p.data))  
                    return p.data; 
                if (p.isLeaf())
                    System.out.println("����"+p.data+"��ջ��"+stack.toString());
                stack.push(p);                   //p�����ջ
                p=p.left;                        //����������
            }
            else                                 //pΪ����ջ�ǿ�ʱ
            {
                p=stack.pop();                   //pָ���ջ���
                p=p.right;                       //����������
            }
        return null; 
    }

    //��2�������������������ķǵݹ��㷨���㷨ʹ��front��סp��ǰ�����
    public void postorder()
    {
        System.out.print("������������  ");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p=this.root, front=null;
//����        boolean left=true;                                 //left��������/�������ߣ��������
        while (p!=null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                stack.push(p);                             //p�����ջ
                p=p.left;                                  //����������
//                left=true;                                 //������������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
                p=stack.peek();                            //������������p��㣬p��㲻��ջ
//                if (p.right!=null && left)//p.right!=front)       //p���Һ��ӣ����Һ���û�����ʹ�
                if (p.right!=null && p.right!=front)       //p���Һ��ӣ����Һ���û�����ʹ�
                {
                    p = p.right;                           //����������
//                    left=false;
                }
                else
                {
                    p=stack.pop();                         //������������p��㣬p����ջ
                    System.out.print(p.data+" ");
                    front = p;                             //frontָ��p�ں�����������µ�ǰ�����
                    p=null;                                //p�����Ϸ��ظ�ĸ���
                }
            }
        System.out.println();
    }
    //C++�����㷨���ԣ���1����parent��Ǹ�ĸ�����ʶ�����/���������أ����С�
                  // ��2��Ҷ�ӽ�㲻��ջ�����У���ѭ����
          //��3�� boolean left=true;     //left��������/�������ߣ��������
    
    
    //��3�����������
    //�Ա������������ȸ����й���һ�ö�������prelist����ָ���ȸ��������С�
    //�ȸ���������ķǵݹ��㷨��ʹ��ջ������boolean����leftChild���ִ����Ľ����p����/�Һ��ӣ�Ĭ���������
    public ByStackBinaryTree(T[] prelist)
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

    
    //��4�� �������Ĺ�����ʾ
    //����������Ĺ�����ʾ�ַ�����
    //�����������������ķǵݹ��㷨��ʹ��ջ������frontָ��p��ǰ����㣬���������/���������ء�
    public void printGenList()
    {
        System.out.print("�������Ĺ�����ʾ��");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p=this.root, front=null;             //��frontָ��p�ں�����������µ�ǰ�����
        while (p!=null || !stack.isEmpty()) 
            if (p!=null)
            {
                System.out.print(p.data.toString());       //�ȸ�����������Ԫ��
                stack.push(p);
                if (!p.isLeaf())                           //��Ҷ��
                {
                   System.out.print("(");                  //��������ʱ��������
                   if (p.left==null)
                       System.out.print("��");             //����Ϊ�գ���','֮ǰ���
                }
                p=p.left;                                  //����������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
//                System.out.println("  "+stack.toString());
                p=stack.peek();                            //ջ���Ǹ�ĸ����ȷ���Ǵ���/���������ص�
                if (!p.isLeaf() && p.right!=front)         //p��Ҷ�ӣ����Һ���û�����ʹ�����ʾ������������                if (!p.isLeaf() && p.right!=front)         //p��Ҷ�ӣ����Һ���û�����ʹ�����ʾ������������
//                if ((p.left!=null || p.right!=null) && p.right!=front)         //p��Ҷ�ӣ����Һ���û�����ʹ�����ʾ������������                if (!p.isLeaf() && p.right!=front)         //p��Ҷ�ӣ����Һ���û�����ʹ�����ʾ������������
                    System.out.print(",");
                if (p.left!=null && p.right==null)         //p��Ҷ�����Һ���Ϊ��
                    System.out.print("��"); 
                if (p.right!=null && p.right!=front)       //p���Һ��ӣ����Һ���û�����ʹ�
                    p = p.right;                           //���½���������
                else                                       //p.right==front����ʾ������������p���
                {
                    p=stack.pop();                         //pָ���ջ��㣬�����Ϸ��ظ�ĸ
                    if (!p.isLeaf())                       //p��Ҷ��
                        System.out.print(")");
                    front = p;                             //frontָ��p�ں�����������µ�ǰ�����
                    p=null;                                //p�����Ϸ��ظ�ĸ���
                }

            }
        System.out.println();
    }

    //��ʵ����6-3��������������ǵݹ��㷨��ʹ��ջ
//??    public ByStackBinaryTree(BinaryTree<T> tree)

    //�ȸ���������㷨������leftChild���ִ����Ľ����q����/�Һ��ӣ�Ĭ���������
//    public static<T> ByStackBinaryTree<T> copy(BinaryTree<T> bitree)
    public ByStackBinaryTree(BinaryTree<T> bitree)
    {
        this();
//        ByStackBinaryTree<T> copytree = new ByStackBinaryTree<T>();
//        if (bitree.isEmpty()) 
//            return copytree;
        Stack<BinaryNode<T>> stack1 = new SeqStack<BinaryNode<T>>();    //ջ
        Stack<BinaryNode<T>> stack2 = new LinkedStack<BinaryNode<T>>(); //ջ
        this.root = new BinaryNode<T>(bitree.root.data);  //���������
        stack1.push(bitree.root);                         //������ջ
        stack2.push(this.root);                           //������ջ
        BinaryNode<T> p=bitree.root.left, q=this.root;
        boolean leftChild=true;                  //leftChild���ֽ�����q����/�Һ��ӣ�Ĭ���������
        while (p!=null || !stack1.isEmpty())     //ʹ��p����bitree������
        {
            if (p!=null)
            {      //����p��㣬����q����/�Һ��ӽ�㣨ֵΪp.data�����������ջ��������           
                if (leftChild)
                {            
                    q.left = new BinaryNode<T>(p.data);
                    q = q.left;
                }
                else
                {
                    q.right = new BinaryNode<T>(p.data);
                    q=q.right;
                }
                stack1.push(p);
                stack2.push(q);
                p = p.left;                      //����p��������
                leftChild = true;                //֮�󽫴���q������
            }
            else       //�����������꣬����ջ�����ظ�ĸ�����Ƚ�㣬�ٽ���p��������                                 
            {
                p = stack1.pop(); 
                q = stack2.pop();
                p = p.right;                     //����p��������
                leftChild = false;               //֮�󽫴���q���Һ���
            }
        }
    }
}
    /*����δ���2015��10��28��
    //�Բ�α������й�����ȫ������
    //�����ȸ���������ķǵݹ��㷨��ʹ��ջ������boolean����leftChild���ִ����Ľ����p����/�Һ��ӣ�Ĭ���������
    public static<T> BinaryTree<T> createComplete(T[] levellist)
    {
        BinaryTree<T> bitree = new BinaryTree<T>();        //����ն�����
        if (levellist.length==0) 
            return bitree;
        bitree.root = new BinaryNode<T>(levellist[0]);     //���������
        Stack<BinaryNode<T>> stack_node = new SeqStack<BinaryNode<T>>(); //ջ
        Stack<Integer> stack_i = new LinkedStack<Integer>(); //ջ
        stack_node.push(bitree.root);                           //������ջ
        stack_i.push(0);                           //��ջ
        BinaryNode<T> p = bitree.root;
        boolean leftChild=true;                  //leftChild���ֽ�����p����/�Һ��ӣ�Ĭ���������
        int i=1; 
        while (!stack_node.isEmpty())
            if (i<levellist.length)
            {
                if (leftChild)
                {
                p.left = new BinaryNode<T>(levellist[i]);//����p�����ӽ��
                p=p.left;                              //����������
                stack_node.push(p);                           //����ջ
                stack_i.push(i);                           //����ջ

                i=2*i+1;
                leftChild=true;
                }
                else
                {
                    p.right = new BinaryNode<T>(levellist[i]);//����p���Һ��ӽ��
                    p=p.right;                              //����������
                }
            }
            else
            {
                p=stack_node.pop();                              //�մ����Ľ���ջ
                i=stack_i.pop();
                i=2*i+2;
                leftChild=false;
            }
        return bitree;
    }


}

/*����δ���2014��5��26��
//�����������prelist��inlist����ֱ�ָ���ȸ����и��������У�nָ�����г���
//ʹ��ջ�������и���������������ķǵݹ��㷨������bool����left��������/��������
//���ȸ����и����й����Ӷ��������ȸ������д�prelist�����preStart��ʼ�������������
//prelist[preStart]���и������д�inlist�����inStart��ʼ��nָ�������г��ȣ����ظ�����ַ
template <class T>
void create(BinaryTree<T> &bitree, SeqList<T> &prelist, SeqList<T> &inlist)
{ 
    int n = prelist.count();
    if (n<0)  return;
    SeqStack<BinaryNode<T>*> stack;                        //ջ
    SeqStack<int> stacki;                        //ջ
    bitree.root = new BinaryNode<T>(prelist[0]);
    BinaryNode<T> *p=bitree.root;
    bool left=true;
    int preStart=0, inStart=0;
    int i=0;
    while (i<n)
    {
        int inRoot = inlist.search(prelist[i]);         //���и������в��Ҹ�ֵ����λ��
        stacki.push(inRoot);
        stack.push(p);                              //������������Ҷ�ӽ���ջ
        cout<<"push:"<<(p->data)<<"��"<<stack<<endl;
        i++;
        if (i<n)
        {
            
            if (left)
            {            
                p->left = new BinaryNode<char>(prelist[i++]);//�������ӽ��
                p = p->left;                                 //����������
            }
            else
            {
                p->right = new BinaryNode<char>(prelist[i++]); //�����Һ��ӽ��
                p = p->right;                               //����������
            }
            stack.push(p);                              //������������Ҷ�ӽ���ջ
            cout<<"push:"<<(p->data)<<"��"<<stack<<endl;
            left = true;
        }
        else
        {
            p = stack.pop();                                 //�����������ظ����p��p����ջ
            left = false;
            i++;
        }
}
    BinaryNode<T> *p=null;
    if (n>0)
    {
        T elem=prelist[preStart];                          //�����ֵ
        p = new BinaryNode<T>(elem);                       //�������
        int i=0;
        while (i<n && elem!=inlist[inStart+i])             //���и������в��Ҹ�ֵ����λ��
            i++;
        p->left = create(prelist, inlist, preStart+1, inStart, i);           //����������
        p->right = create(prelist, inlist, preStart+i+1, inStart+i+1, n-1-i);//����������
    }
    return p;
}
*/