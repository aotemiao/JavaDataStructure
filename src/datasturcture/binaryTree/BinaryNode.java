package datasturcture.binaryTree;//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��25��
//��6.1.3   �������Ķ�������ʵ��
//1.  ������������

public class BinaryNode<T>                       //�������Ķ����������࣬Tָ������Ԫ������
{
    public T data;                               //�����򣬴洢����Ԫ��
    public BinaryNode<T> left, right;            //���򣬷ֱ�ָ�����Һ��ӽ��

    //�����㣬dataָ��Ԫ�أ�left��right�ֱ�ָ�����Ӻ��Һ��ӽ��
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public BinaryNode(T data)                    //����Ԫ��Ϊdata��Ҷ�ӽ��
    {
        this(data, null, null);
    }

    public String toString()                     //���ؽ��������������ַ���
    {
        return this.data.toString();
    }

    public boolean isLeaf()                      //�ж��Ƿ�Ҷ�ӽ��
    {
        return this.left==null && this.right==null;
    }
}
/*
//ע�⣺BinaryNode<T>�����ʵ��toString()��������Ϊ���������Object���toString()������
    SeqStack<BinaryNode<ExpData>> stack = new SeqStack<BinaryNode<ExpData>>();
    LinkedStack<BinaryNode<ExpData>> stack = new LinkedStack<BinaryNode<ExpData>>();

    //���������·���
    public BinaryNode()
    {
        this(null, null, null);
    }
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof BinaryNode<?> && this.data.equals(((BinaryNode<T>)obj).data);
    }    
*/
//@author��Yeheya��2014-10-9��2019��7��26��