package datasturcture.stack;

//import datasturcture.list.SeqList;

import datasturcture.list.SeqList;

/**
 * @author aotemiao
 * @date 2020/12/21 14:44
 */
//1. ˳��ջ

//˳��ջ�࣬�����࣬ʵ��ջ�ӿڣ�T��ʾ����Ԫ�ص���������
public final class SeqStack<T> implements Stack<T>
{
    private SeqList<T> list;                     //ʹ��˳���2.2.2�ڣ��洢ջԪ��

    public SeqStack(int length)                  //��������Ϊlength�Ŀ�ջ
    {
        this.list = new SeqList<T>(length);      //ִ��˳����췽��
    }
    public SeqStack()                            //����Ĭ�������Ŀ�ջ
    {
        this(64);
    }

    public boolean isEmpty()                     //�ж�ջ�Ƿ�գ���Ϊ�գ��򷵻�true
    {
        return this.list.isEmpty();
    }

    public void push(T x)                        //Ԫ��x��ջ���ն�������ջ
    {
        this.list.insert(x);                     //˳���β����Ԫ��x���Զ���������
    }

    public T peek()                              //����ջ��Ԫ�أ�δ��ջ������ջΪ�գ��򷵻�null
    {
        return this.list.get(list.size()-1);     //��ջΪ�գ���get(i)����null
//        return this.isEmpty() ? null : this.list.get(list.size()-1);
    }

    public T pop()                               //��ջ������ջ��Ԫ�أ���ջΪ�գ��򷵻�null
    {
        return this.list.remove(list.size()-1);  //��ջ���գ�˳���βɾ��������ɾ��Ԫ��
    }

    //���½̲�ûд
    public String toString()                     //����ջ����Ԫ�ص������ַ�������ʽΪ��(,)��
    {
        return //this.getClass().getName()+
                this.list.toString();//���˳���
    }
    public String toPreviousString()             //�������˳��ջ
    {
        return //this.getClass().getName()+" "+
                this.list.toPreviousString();//�������˳���
    }

    //����������ֱ�������õ�
    public SeqStack(SeqStack<T> stack)           //ջ������췽��
    {
        this.list = new SeqList<T>(stack.list);  //ִ��˳����������췽��
    }
    public void copy(SeqStack<T> stack)          //ջ���
    {
        this.list = new SeqList<T>(stack.list);  //ִ��˳����������췽��
    }
    public void clear()                          //���ջ
    {
        this.list.clear();
    }
    public int size()                            //����Ԫ�ظ�����O(1)
    {
        return this.list.size();
    }
}
//@author��Yeheya��2014��7��1�գ�2019��10��5�գ�2020��7��23��