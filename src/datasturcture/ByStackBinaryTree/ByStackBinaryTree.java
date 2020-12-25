package datasturcture.ByStackBinaryTree;//《数据结构（Java版）（第5版）试题库》，作者：叶核亚，2015年8月10日
//§6.2.6   二叉树的二叉链表实现
//【实验题6-4】二叉树操作的非递归算法，使用栈。

import datasturcture.binaryTree.BinaryNode;
import datasturcture.binaryTree.BinaryTree;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;

//二叉树类，二叉链表存储； 非递归算法，使用栈。
public class ByStackBinaryTree<T> extends BinaryTree<T>
{
    public ByStackBinaryTree()                   //构造空二叉树
    {
         super();
    }

    //（1）先根次序遍历算法的非递归算法，使用栈
    //查找首次出现关键字为key元素，若未找到返回null
    public T search(T key)
    {
        System.out.print("先根次序遍历：  ");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //栈
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())      //p非空或栈非空时
            if (p!=null)
            {
                if (key.equals(p.data))  
                    return p.data; 
                if (p.isLeaf())
                    System.out.println("访问"+p.data+"，栈是"+stack.toString());
                stack.push(p);                   //p结点入栈
                p=p.left;                        //进入左子树
            }
            else                                 //p为空且栈非空时
            {
                p=stack.pop();                   //p指向出栈结点
                p=p.right;                       //进入右子树
            }
        return null; 
    }

    //（2）后根次序遍历二叉树的非递归算法。算法使用front记住p的前驱结点
    public void postorder()
    {
        System.out.print("后根次序遍历：  ");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p=this.root, front=null;
//不行        boolean left=true;                                 //left区分向左/右子树走，先左后右
        while (p!=null || !stack.isEmpty())                //p非空或栈非空时
            if (p!=null)
            {
                stack.push(p);                             //p结点入栈
                p=p.left;                                  //进入左子树
//                left=true;                                 //向左右子树走
            }
            else                                           //p为空且栈非空时
            {
                p=stack.peek();                            //从左子树返回p结点，p结点不出栈
//                if (p.right!=null && left)//p.right!=front)       //p有右孩子，且右孩子没被访问过
                if (p.right!=null && p.right!=front)       //p有右孩子，且右孩子没被访问过
                {
                    p = p.right;                           //进入右子树
//                    left=false;
                }
                else
                {
                    p=stack.pop();                         //从右子树返回p结点，p结点出栈
                    System.out.print(p.data+" ");
                    front = p;                             //front指向p在后根遍历次序下的前驱结点
                    p=null;                                //p再向上返回父母结点
                }
            }
        System.out.println();
    }
    //C++其他算法测试，〈1〉用parent标记父母结点来识别从左/右子树返回，不行。
                  // 〈2〉叶子结点不进栈，不行，死循环。
          //〈3〉 boolean left=true;     //left区分向左/右子树走，先左后右
    
    
    //（3）构造二叉树
    //以标明空子树的先根序列构造一棵二叉树，prelist数组指定先根遍历序列。
    //先根次序遍历的非递归算法，使用栈，声明boolean变量leftChild区分创建的结点是p的左/右孩子，默认先左后右
    public ByStackBinaryTree(T[] prelist)
    {  
        this();                                            //构造空二叉树
        if (prelist.length==0) 
            return;
        this.root = new BinaryNode<T>(prelist[0]);         //创建根结点
        Stack<BinaryNode<T>> stack = new SeqStack<BinaryNode<T>>(); //空栈
        stack.push(this.root);                             //根结点进栈
        BinaryNode<T> p = this.root;
        boolean leftChild=true;                  //leftChild区分将创建p的左/右孩子，默认先左后右
        for (int i=1; i<prelist.length; i++)
            if (prelist[i]!=null)
            {
                if (leftChild)
                {            
                    p.left = new BinaryNode<T>(prelist[i]);//创建p的左孩子结点
                    p=p.left;                              //进入左子树
                }
                else
                {
                    p.right = new BinaryNode<T>(prelist[i]);//创建p的右孩子结点
                    p=p.right;                              //进入右子树
                }
                stack.push(p);                              //刚创建的结点进栈
                leftChild = true;                           //之后将创建p的左孩子
            }
            else                                 //遇到'^'
            {
                p = stack.pop();                 //结点出栈，从左子树返回父母或祖先结点p
                leftChild = false;               //之后将创建p的右孩子
            }
    }
    //@author  Yeheya。2016-12-29，修改测试，出栈后，创建右孩子结点，未成功。

    
    //（4） 二叉树的广义表表示
    //输出二叉树的广义表表示字符串。
    //后根次序遍历二叉树的非递归算法，使用栈，声明front指向p的前驱结点，以区别从左/右子树返回。
    public void printGenList()
    {
        System.out.print("二叉树的广义表表示：");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p=this.root, front=null;             //设front指向p在后根遍历次序下的前驱结点
        while (p!=null || !stack.isEmpty()) 
            if (p!=null)
            {
                System.out.print(p.data.toString());       //先根次序输出结点元素
                stack.push(p);
                if (!p.isLeaf())                           //非叶子
                {
                   System.out.print("(");                  //即有子树时，用括号
                   if (p.left==null)
                       System.out.print("∧");             //左孩子为空，在','之前输出
                }
                p=p.left;                                  //进入左子树
            }
            else                                           //p为空且栈非空时
            {
//                System.out.println("  "+stack.toString());
                p=stack.peek();                            //栈顶是父母，再确定是从左/右子树返回的
                if (!p.isLeaf() && p.right!=front)         //p非叶子，且右孩子没被访问过，表示从左子树返回                if (!p.isLeaf() && p.right!=front)         //p非叶子，且右孩子没被访问过，表示从左子树返回
//                if ((p.left!=null || p.right!=null) && p.right!=front)         //p非叶子，且右孩子没被访问过，表示从左子树返回                if (!p.isLeaf() && p.right!=front)         //p非叶子，且右孩子没被访问过，表示从左子树返回
                    System.out.print(",");
                if (p.left!=null && p.right==null)         //p非叶子且右孩子为空
                    System.out.print("∧"); 
                if (p.right!=null && p.right!=front)       //p有右孩子，且右孩子没被访问过
                    p = p.right;                           //向下进入右子树
                else                                       //p.right==front，表示从右子树返回p结点
                {
                    p=stack.pop();                         //p指向出栈结点，再向上返回父母
                    if (!p.isLeaf())                       //p非叶子
                        System.out.print(")");
                    front = p;                             //front指向p在后根遍历次序下的前驱结点
                    p=null;                                //p再向上返回父母结点
                }

            }
        System.out.println();
    }

    //【实验题6-3】二叉树深拷贝，非递归算法，使用栈
//??    public ByStackBinaryTree(BinaryTree<T> tree)

    //先根次序遍历算法，声明leftChild区分创建的结点是q的左/右孩子，默认先左后右
//    public static<T> ByStackBinaryTree<T> copy(BinaryTree<T> bitree)
    public ByStackBinaryTree(BinaryTree<T> bitree)
    {
        this();
//        ByStackBinaryTree<T> copytree = new ByStackBinaryTree<T>();
//        if (bitree.isEmpty()) 
//            return copytree;
        Stack<BinaryNode<T>> stack1 = new SeqStack<BinaryNode<T>>();    //栈
        Stack<BinaryNode<T>> stack2 = new LinkedStack<BinaryNode<T>>(); //栈
        this.root = new BinaryNode<T>(bitree.root.data);  //创建根结点
        stack1.push(bitree.root);                         //根结点进栈
        stack2.push(this.root);                           //根结点进栈
        BinaryNode<T> p=bitree.root.left, q=this.root;
        boolean leftChild=true;                  //leftChild区分将创建q的左/右孩子，默认先左后右
        while (p!=null || !stack1.isEmpty())     //使用p遍历bitree二叉树
        {
            if (p!=null)
            {      //到达p结点，创建q的左/右孩子结点（值为p.data），两结点入栈，再向左           
                if (leftChild)
                {            
                    q.left = new BinaryNode<T>(p.data);
                    q = q.left;
                }
                else
                {
                    q.right = new BinaryNode<T>(p.data);
                    q=q.right;
                }
                stack1.push(p);
                stack2.push(q);
                p = p.left;                      //进入p的左子树
                leftChild = true;                //之后将创建q的左孩子
            }
            else       //左子树遍历完，结点出栈，返回父母或祖先结点，再进入p的右子树                                 
            {
                p = stack1.pop(); 
                q = stack2.pop();
                p = p.right;                     //进入p的右子树
                leftChild = false;               //之后将创建q的右孩子
            }
        }
    }
}
    /*？？未完成2015年10月28日
    //以层次遍历序列构造完全二叉树
    //？？先根次序遍历的非递归算法，使用栈，声明boolean变量leftChild区分创建的结点是p的左/右孩子，默认先左后右
    public static<T> BinaryTree<T> createComplete(T[] levellist)
    {
        BinaryTree<T> bitree = new BinaryTree<T>();        //构造空二叉树
        if (levellist.length==0) 
            return bitree;
        bitree.root = new BinaryNode<T>(levellist[0]);     //创建根结点
        Stack<BinaryNode<T>> stack_node = new SeqStack<BinaryNode<T>>(); //栈
        Stack<Integer> stack_i = new LinkedStack<Integer>(); //栈
        stack_node.push(bitree.root);                           //根结点进栈
        stack_i.push(0);                           //进栈
        BinaryNode<T> p = bitree.root;
        boolean leftChild=true;                  //leftChild区分将创建p的左/右孩子，默认先左后右
        int i=1; 
        while (!stack_node.isEmpty())
            if (i<levellist.length)
            {
                if (leftChild)
                {
                p.left = new BinaryNode<T>(levellist[i]);//创建p的左孩子结点
                p=p.left;                              //进入左子树
                stack_node.push(p);                           //结点进栈
                stack_i.push(i);                           //结点进栈

                i=2*i+1;
                leftChild=true;
                }
                else
                {
                    p.right = new BinaryNode<T>(levellist[i]);//创建p的右孩子结点
                    p=p.right;                              //进入右子树
                }
            }
            else
            {
                p=stack_node.pop();                              //刚创建的结点进栈
                i=stack_i.pop();
                i=2*i+2;
                leftChild=false;
            }
        return bitree;
    }


}

/*？？未完成2014年5月26日
//构造二叉树，prelist、inlist数组分别指定先根和中根遍历序列，n指定序列长度
//使用栈，采用中根次序遍历二叉树的非递归算法，采用bool变量left区分向左/右子树走
//以先根和中根序列构造子二叉树，先根子序列从prelist数组的preStart开始，子树根结点是
//prelist[preStart]；中根子序列从inlist数组的inStart开始，n指定子序列长度；返回根结点地址
template <class T>
void create(BinaryTree<T> &bitree, SeqList<T> &prelist, SeqList<T> &inlist)
{ 
    int n = prelist.count();
    if (n<0)  return;
    SeqStack<BinaryNode<T>*> stack;                        //栈
    SeqStack<int> stacki;                        //栈
    bitree.root = new BinaryNode<T>(prelist[0]);
    BinaryNode<T> *p=bitree.root;
    bool left=true;
    int preStart=0, inStart=0;
    int i=0;
    while (i<n)
    {
        int inRoot = inlist.search(prelist[i]);         //在中根序列中查找根值所在位置
        stacki.push(inRoot);
        stack.push(p);                              //创建左子树，叶子结点进栈
        cout<<"push:"<<(p->data)<<"，"<<stack<<endl;
        i++;
        if (i<n)
        {
            
            if (left)
            {            
                p->left = new BinaryNode<char>(prelist[i++]);//创建左孩子结点
                p = p->left;                                 //进入左子树
            }
            else
            {
                p->right = new BinaryNode<char>(prelist[i++]); //创建右孩子结点
                p = p->right;                               //进入右子树
            }
            stack.push(p);                              //创建左子树，叶子结点进栈
            cout<<"push:"<<(p->data)<<"，"<<stack<<endl;
            left = true;
        }
        else
        {
            p = stack.pop();                                 //从左子树返回根结点p，p结点出栈
            left = false;
            i++;
        }
}
    BinaryNode<T> *p=null;
    if (n>0)
    {
        T elem=prelist[preStart];                          //根结点值
        p = new BinaryNode<T>(elem);                       //创建结点
        int i=0;
        while (i<n && elem!=inlist[inStart+i])             //在中根序列中查找根值所在位置
            i++;
        p->left = create(prelist, inlist, preStart+1, inStart, i);           //创建左子树
        p->right = create(prelist, inlist, preStart+i+1, inStart+i+1, n-1-i);//创建右子树
    }
    return p;
}
*/