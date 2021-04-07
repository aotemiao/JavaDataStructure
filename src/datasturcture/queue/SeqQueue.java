package datasturcture.queue;

/**
 * @author aotemiao
 * @date 2020/12/21 15:14
 */
//1.  顺序循环队列

//顺序循环队列类，最终类，实现队列接口，T表示数据元素的数据类型
public final class SeqQueue<T>  implements QueueAPI<T>
{
    private Object element[];                    //存储队列数据元素的数组
    private int front, rear;                     //front、rear分别为队列头尾下标
    private static final int MIN_CAPACITY=4;     //常量，指定element数组容量的最小值
    ////说明：教材容量最小值默认16，同顺序表。此处取值，为了习题画图，构造循环。

    public SeqQueue(int length)                  //构造空队列，length指定数组容量
    {
        if(length<MIN_CAPACITY)
            length=MIN_CAPACITY;                 //设置队列数组容量最小值
        this.element = new Object[length];
        this.front = this.rear = 0;              //设置空队列
    }
    public SeqQueue()                            //构造空队列，默认容量
    {
        this(MIN_CAPACITY);                      //默认队列数组容量取最小值
    }

    public boolean isEmpty()                     //判断队列是否空，若为空，则返回true
    {
        return this.front==this.rear;
    }

    public boolean add(T x)            //元素x入队，空对象不能入队。当队列满时，自动扩容
    {
        if(x==null)
            return false;
        if(this.front==(this.rear+1)%this.element.length) //若队列满，则扩充数组
        {
            Object[] temp = this.element;
            this.element = new Object[temp.length*2];      //重新申请一个容量更大的数组
            int j=0;
            for(int i=this.front;  i!=this.rear;  i=(i+1) % temp.length) //按照队列元素次序复制数组元素
                this.element[j++] = temp[i];
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1) % this.element.length;
        return true;
    }

    public T peek()                              //返回队头元素，没有删除。若队列空，则返回null
    {
        return this.isEmpty() ? null : (T)this.element[this.front];
    }

    public T poll()                              //出队，返回队头元素，若队列空，则返回null
    {
        if(this.isEmpty())
            return null;
        T temp = (T)this.element[this.front];
        this.front = (this.front+1) % this.element.length;
        return temp;
    }

    //教材没写，用//§7.3.2   图的广度优先搜索遍历
    public String toString()                     //返回队列所有元素的描述字符串，形式为“(,)”，按照队列元素次序
    {
        StringBuffer strbuf = new StringBuffer(this.getClass().getName()+"(");
        for(int i=this.front;  i!=this.rear;  i=(i+1)%this.element.length)//按照队列元素次序输出
            strbuf.append(this.element[i].toString()+",");
//            strbuf.append(this.element[i].toString()+(i!=this.rear?",":""));////？？没成功
        if(this.isEmpty())
            strbuf.append(')');
        else
            strbuf.setCharAt(strbuf.length()-1, ')');      //将串最后多余的一个字符','改为')'
        strbuf.append("，front="+front+"，rear="+rear);
        return new String(strbuf);                         //由StringBuffer对象构造String对象
    }
}
//@author：Yeheya。2014年7月3日，2019年7月24日