package datasturcture.stack;

/**
 * @author aotemiao
 * @date 2020/12/21 14:43
 */
//ջ�ӿڣ�����ջ�����������ͣ�T�Ƿ��Ͳ�������ʾ����Ԫ�ص���������
public interface StackAPI<T>
{
    public abstract boolean isEmpty();           //�ж�ջ�Ƿ��
    public abstract void push(T x);              //Ԫ��x��ջ
    public abstract T peek();                    //����ջ��Ԫ�أ�δ��ջ
    public abstract T pop();                     //��ջ������ջ��Ԫ��

    //����������ֱ�������õ�
    public abstract void clear();                //���ջ
}
//@author��Yeheya��2014��10��23�գ�2019��7��23�գ�2020��7��23��