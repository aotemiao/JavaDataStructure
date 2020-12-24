package datasturcture.queue;

import datasturcture.list.Node;

/**
 * @author aotemiao
 * @date 2020/12/21 15:12
 */
//��ʽ�����࣬�����࣬ʵ�ֶ��нӿڣ�T��ʾ����Ԫ�ص���������
//ʹ�õ�������ƣ�����ͷ��㡢��rearβָ�룬β����ʱ��O(1)
public final class LinkedQueue<T>  implements Queue<T>
{
    private Node<T> front, rear;                 //front��rear�ֱ�ָ���ͷ�Ͷ�β���

    public LinkedQueue()                         //����ն���
    {
        this.front=this.rear=null;
    }
    public boolean isEmpty()                     //�ж϶����Ƿ�գ����շ���true
    {
        return this.front==null && this.rear==null;
    }

    public boolean add(T x)                      //Ԫ��x��ӣ�x!=null���������ɹ�����true
    {
        if(x==null)
            return false;
        Node<T> q = new Node<T>(x, null);
        if(this.front==null)
            this.front=q;                        //�նӲ���
        else
            this.rear.next=q;                    //����β����
        this.rear=q;
        return true;
    }

    public T peek()                              //���ض�ͷԪ�أ�û��ɾ���������пգ��򷵻�null
    {
        return this.isEmpty() ? null : this.front.data;
    }

    public T poll()                              //���ӣ����ض�ͷԪ�أ������пգ��򷵻�null
    {
        if(isEmpty())
            return null;
        T x = this.front.data;                   //ȡ�ö�ͷԪ��
        this.front = this.front.next;            //ɾ����ͷ���
        if(this.front==null)
            this.rear=null;
        return x;
    }

    public String toString()                     //���ض�������Ԫ�ص������ַ�������ʽΪ��(,)��
    {
        StringBuffer strbuf = new StringBuffer(this.getClass().getName()+"(");
        for(Node<T> p=this.front;  p!=null;  p=p.next)
            strbuf.append(p.data.toString()+(p.next!=null?",":""));
        return new String(strbuf+")");           //��StringBuffer������String����
    }
}
//@author��Yeheya��2014��7��3�գ�2019��7��24��