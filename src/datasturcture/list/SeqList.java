package datasturcture.list;

//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年6月22日
//§2.2  线性表的顺序存储和实现
//§2.2.2  顺序表
//§10.2.2  提供迭代器的类

//1.  顺序表的类声明、存取操作及效率分析
//package dataStructure;                         //声明当前.java文件中的类在指定包中

// 顺序表类，T表示数据元素的数据类型；默认继承Object
public class SeqList<T> extends Object
//        implements java.lang.Iterable<T>//,List<T>   //10.2.2，实现可迭代接口
//public class SeqList<T>  extends MyAbstractList<T> //顺序表类，继承抽象列表类。提供迭代器对象
{
    protected int n;                             // 顺序表元素个数（长度）
    protected Object[] element;                  // 对象数组，保护成员
    private static final int MIN_CAPACITY = 16;    // 常量，指定element数组容量的最小值

    //1. 构造、存取
    // 构造空表，length指定数组容量，若length<MIN_CAPACITY，则取最小值。O(1)
    public SeqList(int length) {
//      super();                                 // 默认调用，执行Object()
        if (length < MIN_CAPACITY)
            length = MIN_CAPACITY;
        this.element = new Object[length];       // 申请数组空间，元素为null
        this.n = 0;
    }//说明：length=0，不能抛出异常，因为空图也要创建空间。

    public SeqList()                             // 创建默认容量的空表，构造方法重载
    {
        this(MIN_CAPACITY);                      // 调用本类已声明的指定参数列表的构造方法
    }

    public SeqList(T[] values)                   // 构造顺序表，由values数组提供元素，忽略其中空对象。O(n)
    {
        // 创建2倍values数组容量的空表，若values==null，则抛出NullPointerException空对象异常
        this(values.length * 2);
        for (int i = 0; i < values.length; i++)     // 复制非空的数组元素
            if (values[i] != null)
                this.element[this.n++] = values[i];// 对象引用赋值
        //也可              this.add(values[i]);           // 尾插入，this.n++。暂且不用，因为还没有讲到

        //也可        for (T x : values)               //数组逐元循环f
//                  this.add(x);                 //尾插入，this.n+1
    }

    public boolean isEmpty()                     // 判断是否空，若为空，则返回true。O(1)
    {
        return this.n == 0;
    }

    public int size()                            // 返回元素个数。O(1)
    {
        return this.n;
    }

    //存取操作
    public T get(int i)                          // 若0≤i<n，返回第i个元素；否则，返回null。O(1)
    {
        if (i >= 0 && i < this.n)
            return (T) this.element[i];           // 返回数组元素引用的对象，传递对象引用
        ////当i<=0 || i>=this.element.length时，Java将抛出ArrayIndexOutOfBoundsException数组下标越界异常
//            return this.element[i];              //编译错，Object对象不能返回T对象
        return null;
//        else throw new java.lang.IndexOutOfBoundsException(i+"");//抛出序号越界异常
        //不能抛出异常。因为null，可以作为循环不执行的条件。
    }

    // 若0≤i<n且x≠null，设置第i个元素为x；否则抛出序号越界异常或空对象异常。O(1)  ////不要返回值。
    public void set(int i, T x) {
        if (x == null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        if (i >= 0 && i < this.n)
            this.element[i] = x;                           //对象引用赋值
        else
            throw new java.lang.IndexOutOfBoundsException(i + "");//抛出序号越界异常
    }

    // 返回所有元素的描述字符串，形式为“(,)”。覆盖Object类的toString()方法。O(n)
    public String toString() {
//        String str=this.getClass().getName()+"(";//返回类名
        String str = "(";
        if (this.n > 0)
            str += this.element[0].toString();   // 执行T类的toString()方法，运行时多态
        for (int i = 1; i < this.n; i++)
            str += "," + this.element[i].toString();
        return str + ") ";                         // 空表返回()
    }

    /*    可行，效率同上
        public String toString()
        {
            String str="(";
            if(this.n()!=0)
            {
                for(int i=0; i<this.n()-1; i++)
                    str += this.get(i).toString()+", ";
                str += this.get(this.n()-1).toString();
            }
            return str+")";
        }
    */
    // 返回所有元素的描述字符串，元素次序从后向前，方法体省略
    // 顺序栈用，O(n)。必需，栈和优先队列用。
    public String toPreviousString() {
//        String str=this.getClass().getName()+"(";       // 返回类名
        String str = "(";
        if (this.n > 0)
            str += this.element[this.n - 1].toString();      // 执行T类的toString()方法，运行时多态
        for (int i = this.n - 2; i >= 0; i--)
            str += "," + this.element[i].toString();
        return str + ") ";                         // 空表返回()
    }

    //2. 顺序表的插入操作
    // 插入x为第i个元素，x!=null，返回插入元素序号。
    // 对i容错，若i<0，则头插入；若i>长度，则尾插入。O(n)
    public int insert(int i, T x) {
        if (x == null)
            return -1;                           // 没有插入。//返回一种执行结果，不是错误，不抛出空对象异常
        if (i < 0)
            i = 0;                                 // 插入位置i容错，插入在最前（头插入）
        if (i > this.n)
            i = this.n;                            // 插入在最后（尾插入）
        Object[] source = this.element;          // 数组变量引用赋值，source也引用element数组
        if (this.n == element.length)               // 若数组满，则扩充顺序表的数组容量
        {
            this.element = new Object[source.length * 2];    // 再申请一个容量更大的数组
            for (int j = 0; j < i; j++)               // 复制当前数组前i-1个元素
                this.element[j] = source[j];     // 复制数组元素，传递对象引用
        }
        for (int j = this.n - 1; j >= i; j--)           // 从i开始至表尾的元素向后移动，次序从后向前
            this.element[j + 1] = source[j];       // 复制数组元素，传递对象引用
        this.element[i] = x;
        this.n++;
        return i;                                // 返回插入元素序号
    }

    public int insert(T x)                       // 顺序表尾插入x元素，O(1)。成员方法重载
    {
        return this.insert(this.n, x);           // 调用insert(i, x)方法
    }
    //何处用到此返回值？之前insert(x)返回int，7.2节 图插入顶点时用，修改
    //10.3.3 Heap<T>类的insert(T x)方法用到返回值

    //3. 顺序表的删除操作
    public T remove(int i)           // 删除第i个元素，0≤i<n，返回被删除元素。若i越界，返回null。O(n)
    {
        if (i >= 0 && i < this.n) {
            T x = (T) this.element[i];            // x中存储被删除元素
            for (int j = i; j < this.n - 1; j++)
                this.element[j] = this.element[j + 1];       // 元素前移一个位置
            this.element[this.n - 1] = null;         // 设置数组元素对象为空，释放原引用实例
            this.n--;
            return x;                            // 返回x局部变量引用的对象，传递对象引用
        }
        return null;
        //throw new IndexOutOfBoundsException(i+"");     // 抛出序号越界异常
    }

    public void clear()                          // 删除所有元素
    {
        this.n = 0;                                // 设置长度为0，未释放数组空间
    }
    //【例2.1】求解Josephus环问题。

    //4. 顺序查找
    // 在this引用的顺序表中，顺序查找首个与key相等元素，返回元素序号i，0≤i<n；若查找不成功，则返回-1。
    // key元素包含作为查找依据的关键字数据项，由T类的equals()方法确定对象是否相等。
    // 若key==null，Java将抛出NullPointerException空对象异常。
    // 顺序表遍历算法，顺序查找算法，O(n)
    public int search(T key) {
//        System.out.print(this.getClass().getName()+".search("+key+")，");
        for (int i = 0; i < this.n; i++)            // 遍历顺序表
        {
//            System.out.print(this.element[i].toString()+"？");
            if (key.equals(this.element[i]))      // 执行T类的equals(Object)方法，运行时多态
                return i;
        }
        return -1;                               // 空表或未找到时
    }//注意：不能用逐元循环，无法返回i。


    // 顺序查找并删除首个与key相等元素，返回被删除元素；若查找不成功，则返回null。
    // 算法利用查找结果确定操作位置
    public T remove(T key) {
        return this.remove(this.search(key));    // 先查找，再调用remove(i)。若查找不成功，返回-1，不删除
    }


    //6.  顺序表的浅拷贝与深拷贝
/*    public SeqList(SeqList<T> list)              // 浅拷贝构造方法
    {
        this.n = list.n;                         // int整数赋值，复制了整数值
        this.element = list.element;             // 数组引用赋值，两个变量共用一个数组，错误
    }
*/

    //第6版，深拷贝，求所有直径程序用到copy(list)，2020年7月23日
    public SeqList(SeqList<? extends T> list)    // 拷贝构造方法，深拷贝，<? extends T>表示T及子类
    {
        this.copy(list);
    }

    public void copy(SeqList<? extends T> list)  // 复制list所有元素到this，放弃this原数组元素。O(n)
    {
        this.element = new Object[list.element.length];// 申请一个数组
        for (int i = 0; i < list.n; i++)              // 复制list所有元素到this
            this.element[i] = list.element[i];   // 对象引用赋值，没有创建新对象
        this.n = list.n;
    }
//以下语法错，不能拷贝对象。
//this.element[i] = new T(list.element[i]);      //语法错，因为Java没有提供默认拷贝构造方法
//this.element[i] = new Object(list.element[i]); //语义错，不需要创建Object对象。
    //语法错，Object没有提供拷贝构造方法，构造方法不能继承
    //将对象赋值改进成以下语句，失败。
//    this.insert((T)list.element[i]);           //尾插入，this.n++，对象仍然引用赋值，没有复制
//因为，子类SortedSeqList(SeqList<? extends T> list)中super(list)，insert(x)运行时多态，遍历到尾再插入，效率O(n*n)


    //7. 顺序表比较相等
    public boolean equals(Object obj)            // 比较this与obj引用的顺序表是否相等。覆盖。O(n)
    {
        System.out.print(this.getClass().getName() + ".equals(" + obj.getClass().getName() + ")，");
        if (this == obj)                            // 若this和obj引用同一个顺序表实例，则相等
            return true;
        if (obj instanceof SeqList<?>)            // 若obj引用顺序表实例。SeqList<?>是所有SeqList<T>的父类
        {
            SeqList<T> list = (SeqList<T>) obj;   // 声明list也引用obj所引用的实例
            if (this.n == list.n)                   // 则比较两者长度是否相等
            {
                for (int i = 0; i < this.n; i++)    // 再比较两个顺序表的所有元素是否相等
                    // 一旦发现有两个对应元素不相等，则可确定两个顺序表不相等。equals(Object)运行时多态
                    if (!(this.element[i].equals(list.element[i])))
                        return false;
                return true;
            }
        }
        return false;
    }
    //以上实现ADT List，第2章2.2.2节内容

/*    ////以下第5版没写
    public boolean contains(T key)               //判断是否包含关键字为key元素
    {
        return this.search(key)!=-1;//顺序查找首个与key相等元素，返回元素序号i，0≤i<n；若查找不成功返回-1
    }*/

    ////以下第5版没写
    //8.  集合并运算，泛型的继承性
    //子类继承，不需要覆盖，插入运行时多态
    //集合并运算，在this之后添加list所有元素，this+=list功能；<? extends T>表示T及子类
    public void addAll(SeqList<? extends T> list) {
        for (int i = 0; i < list.n; i++)
            this.insert(list.get(i));        //运行时多态，顺序表尾插入；排序顺序表按值插入
    }
    //说明：调用this.get(i)，O(1)，比用(T)this.element[i]语义上更清楚。下同。

//如果  public void addAll(SeqList<T> list)          //则不接受T的子类
//如果  public void addAll(SeqList<?> list)          //则调用this.insert(x)，编译错
//如果  public void insert(SeqList<T> list)          //重载，调用时，当参数为null时，编译错，无法识别重载方法中的哪一个

    //返回在this之后连接list的顺序表，即返回this+list的并集功能，不改变this和list
    public SeqList<T> union(SeqList<? extends T> list) {
        SeqList<T> result = new SeqList<T>(this);   //深拷贝this，无法创建子类实例
        result.addAll(list);                        //顺序表合并连接，尾插入
        return result;                              //只能返回SeqList<T>对象，子类要覆盖
    }
    //不行        return new SeqList<T>(this).addAll(list);
    //9.5.1 子类mergeAll合并、归并，不用，不声明

    //【实验题2-1】第5版没写
    //返回从begin～end元素组成的子表。意为返回T的某个子类。
//  SeqList<? extends T> subList(int begin, int end)   //不需要该语法
    SeqList<T> subList(int begin, int end) {
        SeqList<T> list = new SeqList<T>();
        for (int i = begin; i < end; i++)
            list.insert(this.get(i));
        return list;
    }


//    //第10章
//    //§10.2.2   提供迭代器对象的类
//    //1.  顺序表类提供迭代器
//    public java.util.Iterator<T>  iterator()     // 返回迭代器对象，实现Iterable<T>可迭代接口
//    {
//        return new SeqIterator();
//    }
//    private class SeqIterator  implements java.util.Iterator<T>// 私有内部类，实现迭代器接口
//    {
//        int index=-1, succ=0;                    // 当前元素和后继元素序号
//        public boolean hasNext()                 // 若有后继元素，返回true
//        {
//            return this.succ<SeqList.this.n;     // SeqList.this.n是外部类当前实例的成员变量
//        }
//        public T next()                          // 返回后继元素，若没有后继元素，返回null
//        {
//            T value = SeqList.this.get(this.succ);// 调用外部类SeqList当前实例的成员方法
//            if(value!=null)
//            {
//                this.index = this.succ++;
//                return value;
//            }
//            throw new java.util.NoSuchElementException();  // 抛出无此元素异常
//        }
//        public void remove()                     // 删除迭代器对象表示的集合当前元素
//        {
//            if(this.index>=0 && this.index<SeqList.this.n)
//            {
//                // 调用外部类SeqList当前实例的成员方法，删除第index个元素，长度SeqList.this.n-1
//                SeqList.this.remove(this.index);
//                if(this.succ>0)
//                    this.succ--;
//                this.index=-1;                   // 设置不能连续删除的标记
//            }
//            else throw new java.lang.IllegalStateException(); // 抛出无效状态异常
//        }
//    }//SeqIterator内部类结束
//
//
//    //【思考题10-3】顺序表类提供列表迭代器。
//    public java.util.ListIterator<T> listIterator()        //返回Java列表迭代器对象
//    {
//        return new SeqListIterator(0);
//    }
//    public java.util.ListIterator<T> listIterator(final int index) //返回Java列表迭代器对象
//    {
//        if(index>=0 && index<this.n)
//            return new SeqListIterator(index);
//        else throw new IndexOutOfBoundsException("Index: "+index);
//    }
//
//    //私有内部类，继承实现迭代器接口的SeqIterator内部类，实现列表迭代器接口
//    private class SeqListIterator extends SeqIterator implements java.util.ListIterator<T>
//    {
//        public SeqListIterator(int index)
//        {
//            this.succ=index;
//        }
//        public boolean hasPrevious()             //若有前驱元素，返回true
//        {
//            return this.succ!=0;
//        }
//
//        public T previous()                      //返回前驱元素
//        {
//            T value = SeqList.this.get(this.succ-1);
//            if(value!=null)
//            {
//                this.index = this.succ--;
//                return value;
//            }
//            throw new java.util.NoSuchElementException();  //抛出无此元素异常
//        }
//
//        public int nextIndex()                   //返回后继元素序号
//        {
//            return this.succ;
//        }
//        public int previousIndex()               //返回前驱元素序号
//        {
//            return this.succ-1;
//        }
//
//        public void set(T x)                     //将集合当前元素替换为x
//        {
//            if(this.index>=0 && this.index<SeqList.this.n)
//                SeqList.this.set(this.index, x); //调用外部类当前实例的成员方法
//            else throw new java.lang.IllegalStateException(); //抛出无效状态异常
//        }
//        public void add(T x)                     //增加元素x
//        {
//            SeqList.this.insert(this.succ, x);   //调用外部类当前实例的成员方法
//            this.succ++;                         //插入元素为当前元素
//        }
//    }//SeqListIterator内部类结束
}
//@author：Yeheya。2015-4-19，2019年8月6日，2020年7月30日