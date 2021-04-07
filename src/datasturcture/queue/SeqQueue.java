package datasturcture.queue;

/**
 * @author aotemiao
 * @date 2020/12/21 15:14
 */
//1.  ˳��ѭ������

//˳��ѭ�������࣬�����࣬ʵ�ֶ��нӿڣ�T��ʾ����Ԫ�ص���������
public final class SeqQueue<T>  implements QueueAPI<T>
{
    private Object element[];                    //�洢��������Ԫ�ص�����
    private int front, rear;                     //front��rear�ֱ�Ϊ����ͷβ�±�
    private static final int MIN_CAPACITY=4;     //������ָ��element������������Сֵ
    ////˵�����̲�������СֵĬ��16��ͬ˳����˴�ȡֵ��Ϊ��ϰ�⻭ͼ������ѭ����

    public SeqQueue(int length)                  //����ն��У�lengthָ����������
    {
        if(length<MIN_CAPACITY)
            length=MIN_CAPACITY;                 //���ö�������������Сֵ
        this.element = new Object[length];
        this.front = this.rear = 0;              //���ÿն���
    }
    public SeqQueue()                            //����ն��У�Ĭ������
    {
        this(MIN_CAPACITY);                      //Ĭ�϶�����������ȡ��Сֵ
    }

    public boolean isEmpty()                     //�ж϶����Ƿ�գ���Ϊ�գ��򷵻�true
    {
        return this.front==this.rear;
    }

    public boolean add(T x)            //Ԫ��x��ӣ��ն�������ӡ���������ʱ���Զ�����
    {
        if(x==null)
            return false;
        if(this.front==(this.rear+1)%this.element.length) //��������������������
        {
            Object[] temp = this.element;
            this.element = new Object[temp.length*2];      //��������һ���������������
            int j=0;
            for(int i=this.front;  i!=this.rear;  i=(i+1) % temp.length) //���ն���Ԫ�ش���������Ԫ��
                this.element[j++] = temp[i];
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1) % this.element.length;
        return true;
    }

    public T peek()                              //���ض�ͷԪ�أ�û��ɾ���������пգ��򷵻�null
    {
        return this.isEmpty() ? null : (T)this.element[this.front];
    }

    public T poll()                              //���ӣ����ض�ͷԪ�أ������пգ��򷵻�null
    {
        if(this.isEmpty())
            return null;
        T temp = (T)this.element[this.front];
        this.front = (this.front+1) % this.element.length;
        return temp;
    }

    //�̲�ûд����//��7.3.2   ͼ�Ĺ��������������
    public String toString()                     //���ض�������Ԫ�ص������ַ�������ʽΪ��(,)�������ն���Ԫ�ش���
    {
        StringBuffer strbuf = new StringBuffer(this.getClass().getName()+"(");
        for(int i=this.front;  i!=this.rear;  i=(i+1)%this.element.length)//���ն���Ԫ�ش������
            strbuf.append(this.element[i].toString()+",");
//            strbuf.append(this.element[i].toString()+(i!=this.rear?",":""));////����û�ɹ�
        if(this.isEmpty())
            strbuf.append(')');
        else
            strbuf.setCharAt(strbuf.length()-1, ')');      //�����������һ���ַ�','��Ϊ')'
        strbuf.append("��front="+front+"��rear="+rear);
        return new String(strbuf);                         //��StringBuffer������String����
    }
}
//@author��Yeheya��2014��7��3�գ�2019��7��24��