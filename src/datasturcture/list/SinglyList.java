package datasturcture.list;

//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月1日
//§2.3 线性表的链式存储和实现
//§2.3.2  单链表
//3. 带头结点的单链表类
//§10.2.2  提供迭代器的类

// 单链表类，T表示数据元素的数据类型；默认继承Object。
////实现List<T>接口，只是为了测试。教材不实现List<T>接口，不声明尾指针
public class SinglyList<T> extends Object //implements List<T>
        //implements java.lang.Iterable<T>    //10.2.2，实现可迭代接口
//public class SinglyList<T> extends MyAbstractList<T>//单链表类，继承抽象列表类//第10章，10.2 实现迭代器
{
    public Node<T> head;                         // 头指针，指向单链表的头结点
    //注意，head不能是其他权限，因为7.2.2节，图的邻接表中，删除顶点要遍历。2014年8月3日

    //（1）构造方法
    public SinglyList()                          //构造方法，构造空单链表
    {
        this.head = new Node<T>();               //创建头结点，data和next值均为null
    }

    //构造单链表，尾插入values数组元素，忽略其中空对象。单链表元素次序与数组元素次序相同。O(n)
    public SinglyList(T[] values) {
        this();                                  //创建空单链表，只有头结点
        Node<T> rear = this.head;                //rear指向单链表最后一个结点
        for (int i = 0; i < values.length; i++)       //若values.length==0，则构造空链表
        {
            if (values[i] != null) {
                rear.next = new Node<T>(values[i], null);  //尾插入，创建结点链入rear结点之后
                rear = rear.next;                //rear指向新的链尾结点
            }
        }
    }

    //（2）判空、存取元素、求长度、返回描述字符串等方法
    public boolean isEmpty()                     //判断是否空，O(1)
    {
        return this.head.next == null;
    }

    public T get(int i)                          //返回第i个元素，0≤i<单链表长度。若i越界，则返回null。O(n)
    {
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)      //遍历单链表，寻找第i个结点（p指向）
            p = p.next;
        return (i >= 0 && p != null) ? p.data : null;//若p指向第i个结点，则返回其元素值
    }

    //设置第i个元素为x，0≤i<单链表长度且x!=null。
    //若x==null，抛出空对象异常；若i序号越界，抛出序号越界异常。O(n)////没有返回值
    public void set(int i, T x) {
        if (x == null)
            throw new NullPointerException("x==null");     //抛出空对象异常
        else {
            Node<T> p = this.head.next;
            for (int j = 0; p != null && j < i; j++)  //遍历寻找第i个结点（p指向）
                p = p.next;
            if (i >= 0 && p != null)
                p.data = x;                       //p指向第i个结点
            else throw new IndexOutOfBoundsException(i + "");//抛出序号越界异常
        }
    }

    //返回所有元素的描述字符串，形式为“(,)”。覆盖Object类的toString()方法，O(n)
    public String toString() {
        String str = "(";
//        String str=this.getClass().getName()+"(";//返回类名
        for (Node<T> p = this.head.next; p != null; p = p.next) //p遍历单链表
        {
//            str += p.data.toString();
//            if(p.next!=null)
//                str += ",";
            str += p.data.toString() + (p.next != null ? "," : "");//不是最后一个结点时，加“,”分隔符
        }
        return str + ")";                          //空表返回()
    }

    public int size()                            //返回单链表长度，O(n)
    {
        int i = 0;
        for (Node<T> p = this.head.next; p != null; p = p.next) //p遍历单链表
            i++;
        return i;
    }

    //（3）插入
    //插入x作为第i个元素，x!=null，返回插入结点。对i容错，若i<0，则头插入；若i>长度，则尾插入。O(n)
    public Node<T> insert(int i, T x) {
        if (x == null)
            return null;               ////没有插入结点。返回一种执行结果，不是错误，不抛出异常
        Node<T> front = this.head;                 //front指向头结点
        for (int j = 0; front.next != null && j < i; j++)  //寻找第i-1个或最后一个结点（front指向）
            front = front.next;
        front.next = new Node<T>(x, front.next); //在front之后插入值为x结点，包括头插入、中间/尾插入
        return front.next;
    }

    public Node<T> insert(T x)                   //单链表尾插入x，O(n)，重载
    {
        //调用insert(i,x)，用整数最大值指定插入在最后，遍历一次，i必须容错
        return insert(Integer.MAX_VALUE, x);     //Integer.MAX_VALUE（0x7fffffff）是整数最大值
        //   return insert(this.size(), x);           //需遍历单链表两次，效率较低
    }
    //何处用到此返回值？第8章【例8.2】  使用散列表表示元素互异的集合。

//    public void insert(SinglyList<T> list){}
    //【说明】可以声明重载。虽然当调用参数为null时，参数列表相同，编译错，产生二义性，编译器不能确定执行重载方法中的哪一个。


    //（4）删除
    public T remove(int i)         //删除第i个元素，0≤i<单链表长度，返回被删除元素。若i越界，则返回null。O(n)
    {
        Node<T> front = this.head;                 //front指向头结点
        for (int j = 0; front.next != null && j < i; j++)//遍历寻找第i-1结点（front指向）
            front = front.next;
        if (i >= 0 && front.next != null)             //若front的后继结点存在，则删除之
        {
            T x = front.next.data;               //获得待删除结点引用的对象
            //删除front的后继结点，包括头删除、中间/尾删除。由Java虚拟机稍后释放结点占用存储单元
            front.next = front.next.next;
            return x;
        }
        return null;                             //若i<0或i>表长，则返回null
//        throw new IndexOutOfBoundsException(i+"");       //抛出序号越界异常
    }

    public void clear()                          //删除单链表所有结点
    {
        this.head.next = null;                   //Java自动收回所有结点占用的存储空间
    }

    //（5）查找，散列表用
    //功能及参数：返回首个与key相等元素结点，若查找不成功返回null
    //特殊情况：若key为空对象，Java将抛出空对象异常
    //算法及效率：顺序查找，O(n)
    //用于7.2.2节图的邻接表，必须返回结点，因为要求后继结点。2014年8月6日，对其他影响未修改

    //（5）顺序查找和基于查找算法的操作。方法体省略
    //8.3 散列集合用，
    public Node<T> search(T key)                 //顺序查找并返回首个与key相等元素结点，若查找不成功，则返回null
    {
//        System.out.print(this.getClass().getName()+".search("+key+")，");
        for (Node<T> p = this.head.next; p != null; p = p.next) {
//          System.out.print(p.data.toString()+"？");
            if (key.equals(p.data))              //执行T类的equals(Object)方法，运行时多态
                return p;
        }
        return null;
    }

    //顺序查找并删除首个与key相等元素结点，返回被删除元素；若查找不成功，则返回null
    public T remove(T key) {
        //以下for循环，p遍历单链表（front指向p的前驱结点），顺序查找与key相等元素结点
        for (Node<T> front = this.head, p = front.next; p != null; front = p, p = p.next) {
            if (key.equals(p.data))               //若查找成功
            {
                front.next = p.next;             //删除front的后继（p结点），包括头删除、中间/尾删除
                return p.data;
            }
        }
        return null;
    }
    //以上实现ADT List，第2章

    //4.  单链表操作的效率分析
    //5.  单链表的应用
    //【例2.2】素数集合，使用单链表。
    //【例2.3】求解Josephus环问题，使用单链表。
    //【实验题2-2】单链表逆转。

    //6. 单链表的浅拷贝与深拷贝
    //【思考题2-5】
    //不行    public SinglyList(SinglyList<? extends T> list)   //深拷贝构造方法，复制单链表list的所有结点
    //相当于Node<? extends T>，即Node<?>

    public SinglyList(SinglyList<T> list)        //深拷贝构造方法，复制单链表list的所有结点
    {
        this();                                  //创建空单链表，只有头结点
        this.copy(list);
    }

    public void copy(SinglyList<T> list)         // 复制list所有元素到this，放弃this原结点。O(n)
    {
        this.clear();                            //设置this为空单链表，即this.head.next = null;
        Node<T> rear = this.head;
        for (Node<T> p = list.head.next; p != null; p = p.next) //p遍历list单链表
        {
            rear.next = new Node<T>(p.data, null);//复制结点尾插入到this单链表；对象引用，没有复制
            rear = rear.next;                    //指向this单链表尾
        }
    }

    public boolean equals(Object obj)            //比较this与obj引用的两条单链表是否相等，覆盖Object类的equals(obj)方法
    {
        System.out.print(this.getClass().getName() + ".equals(" + obj.getClass().getName() + ")，");
        if (this == obj)
            return true;
        if (obj instanceof SinglyList<?>) {
            Node<T> p = this.head.next;
            Node<T> q = ((SinglyList<T>) obj).head.next;
            while (p != null && q != null && p.data.equals(q.data)) {
                p = p.next;
                q = q.next;
            }
            return p == null && q == null;
        }
        return false;
    }

    //7.  单链表的集合并运算
    //【思考题2-6】两条单链表的运算。
    //集合并，this+=list，在this后连接list的所有结点；设置list空，O(n)
    public void concat(SinglyList<T> list) {
        Node<T> rear = this.head;
        while (rear.next != null)                   //rear遍历this单链表，找到最后一个结点
            rear = rear.next;
        rear.next = list.head.next;              //在rear结点之后连接list的首个元素结点
        list.head.next = null;                   //设置list空，否则逻辑错。修改了list引用的单链表
    }

    //集合并，this+=list，在this后连接深拷贝的list；不改变list
    public void addAll(SinglyList<T> list) {
        this.concat(new SinglyList<T>(list));    //先深拷贝单链表list，再连接复制的list
    }

    //以下返回并集（this+list），即返回分别复制this和list后再连接的单链表，this和list不变
    public SinglyList<T> union(SinglyList<T> list) {
        SinglyList<T> result = new SinglyList<T>(this);    //深拷贝this单链表
        result.addAll(list);
        return result;                           //返回result引用的单链表，释放result变量
    }

    //说明：只能返回SinglyList<T>，不能返回子类实例，子类必须覆盖。
    //TODO:判断list是否排序，asc指定升/降序
    public static <T extends Comparable<? super T>> boolean isSorted(SinglyList<T> list, boolean asc) {
        Node<T> p = list.head.next;
        if (asc) {
            while (p.next != null) {
                if (p.data.compareTo(p.next.data) > 0) {
                    return false;
                }
                p = p.next;
            }
        } else {
            while (p.next != null) {
                if (p.data.compareTo(p.next.data) < 0) {
                    return false;
                }
                p = p.next;
            }
        }
        return true;
    }


    //第10章
    //§10.2.2   提供迭代器对象的类
    //2.  单链表类提供迭代器
    public java.util.Iterator<T> iterator()      //返回迭代器对象，实现Iterable<T>可迭代接口
    {
        return new SinglyIterator();
    }

    private class SinglyIterator implements java.util.Iterator<T> //私有内部类，实现迭代器接口
    {
        Node<T> current = SinglyList.this.head;    //当前结点，初值为外部类单链表头结点
        Node<T> front = null;                      //当前结点的前驱结点

        public boolean hasNext()                 //若有后继元素，返回true
        {
            return this.current != null && this.current.next != null;
        }

        public T next()                          //返回后继元素
        {
            if (this.hasNext()) {
                this.front = this.current;
                this.current = this.current.next;
                return this.current.data;
            } else
                throw new java.util.NoSuchElementException();  //抛出无此元素异常
        }

        public void remove()                     //删除迭代器对象表示的集合当前元素
        {
            if (this.front != null) {
                this.front.next = this.current.next; //删除当前结点
                this.current = this.front;
                this.front = null;                     //设置不能连续删除的标记
            } else
                throw new java.lang.IllegalStateException();//抛出无效状态异常
//            throw new UnsupportedOperationException();     //不支持该操作，抛出异常
        }
    }//内部类结束
    //【思考题10-2】
}
/*
//2015年10月4日改进，增加rear尾指针，使尾插入为O(1)。
使用：例2.2 素数集合，例4.3 素数用；
     4.2.2 链式队列；
     5.2.2 矩阵行的单链表；
     8.4.1 散列表。
//2019年7月1日，没有rear尾指针。
 */
//@author：Yeheya，2015-10-5，2019年8月6日