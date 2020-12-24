package datasturcture.queue;

/**
 * @author aotemiao
 * @date 2020/12/21 15:12
 */
//ADT Queue<T>                        //���г����������ͣ�T��ʾ����Ԫ�ص���������
//����ͬjava.util.Queue<T>

public interface Queue<T>              //���нӿڣ��������г����������ͣ�T��ʾ����Ԫ�ص���������
{
    public abstract boolean isEmpty();           //�ж϶����Ƿ��
    public abstract boolean add(T x);            //Ԫ��x��ӣ�����ӳɹ����򷵻�true�����򷵻�false
    public abstract T peek();                    //���ض�ͷԪ�أ�û��ɾ���������пգ��򷵻�null
    public abstract T poll();                    //���ӣ����ض�ͷԪ�ء������пգ��򷵻�null
}
//@author��Yeheya��2014��7��3�գ�2019��7��24��