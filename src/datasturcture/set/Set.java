package datasturcture.set;

//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2016年2月19日
//§1.1.3  数据类型与抽象数据类型
//【例1.1】 集合概念、运算及抽象数据类型。
//方法声明同java.util.Collection<T>。本书指导思想，实现Java集合框架，尽可能。

//ADT Set<T>                                     // 集合抽象数据类型
// 集合接口，描述集合抽象数据类型；T是泛型参数，表示数据元素的数据类型
public interface Set<T>
{
    // 数据：集合中的数据元素，数据元素的数据类型为T；数据元素之间没有关系，互不相同
    // 操作：方法修饰符默认public abstract
    boolean isEmpty();                           // 判断集合是否空
    int size();                                  // 返回元素个数
    String toString();                           // 返回集合所有元素的描述字符串
    boolean add(T x);                            // 增加元素x，没有指定元插入位置；若增加，则返回true
    T search(T key);                             // 查找并返回与key相等元素；若查找不成功，则返回null
    boolean contains(T key);                     // 判断是否包含与key相等元素
    T remove(T key);                             // 查找并删除与key相等元素，返回被删除元素
    void clear();                                // 删除所有元素

    //以下方法声明集合运算，参数是另一个集合
    boolean equals(Object obj);                  // 比较this与obj引用集合是否相等
    boolean containsAll(Set<? extends T> set);   // 判断set是否是this的子集，即this包含set所有元素
    boolean addAll(Set<? extends T> set);        // 集合并，添加set的所有元素
    boolean removeAll(Set<? extends T> set);     // 集合差，删除this中那些也属于set的元素
    boolean retainAll(Set<? extends T> set);     // 集合交，删除this中那些不属于set的元素
}
/*说明：
（1）关于“集合”
    Set<T>声明的“集合”，是数学含义的集合，元素没有关系；这种集合由散列表实现。
       第8章，HashSet<T>类和BinarySortTree<T>类都声明实现Set<T>接口，【典型案例8-1】存储集合。
    §1.1.3  数据类型与抽象数据类型，运行时多态。

       第2章，声明ADT List<T>，不能继承Set<T>接口，因为声明的是线性表，不是数学含义的集合，且没有包含集合运算。

（2）关于Set<T>声明的方法。
    //以下两个方法每个类默认有，还是写了equals()，强调一下。
    String toString();                           //返回集合所有元素的描述字符串
    boolean equals(Object obj);                  //比较this与obj引用集合是否相等

    //以下本书没有用到，HashSet<T>类实现，Java程序设计用到
    Object[] toArray();               //返回包含集合所有元素的数组

    //以下无法实现
     <E> E[] toArray(E[] a);       //返回E类型数组，参数a指定返回的数组类型

    //java.util.Collection<T>声明了contains(T key)，没有声明以下方法，我要用。
     T search(T key);                            //返回查找到的关键字为key元素
     void replace(T key, T x);                   //替换，没有加

*/
//@author：Yeheya。2016-2-20，2019年6月23日，2020年3月6日