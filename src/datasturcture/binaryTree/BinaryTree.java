package datasturcture.binaryTree;

//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��25��
//��6.1.3   �������Ķ�������ʵ��
//2.  ���ö�������洢�Ķ�����������
//��˼����6-2�� ���ڱ����Ĳ���
//����6.1��  �������Ĺ��졢���������롣
//��˼����6-3�������ϰ����

import datasturcture.queue.LinkedQueue;
import datasturcture.queue.Queue;
import datasturcture.stack.LinkedStack;
import datasturcture.stack.SeqStack;
import datasturcture.stack.Stack;

//�������࣬��������洢��Tָ������Ԫ������       //һЩ������Ϊʵ���⣬д��ExBinaryTree<T>����
public class BinaryTree<T> extends Object  //implements BinaryTTree<T>
{
    public BinaryNode<T> root;                   //����㣬����������ṹ

    public BinaryTree()                          //����ն�����
    {
        this.root = null;
    }

    public boolean isEmpty()                     //�ж��Ƿ�ն�����
    {
        return this.root == null;
    }

    //3. �������Ĳ�����
    public void insert(T x)            //����xԪ����Ϊ����㣬x!=null��ԭ�������Ϊx������
    {
        if (x != null)
            this.root = new BinaryNode<T>(x, this.root, null);
    }
    //ע�⣺��������ΪinsertRoot(T x)����Ϊ��һ��������û�У������÷����ɱ����ࣨ���������������ǡ�
    //�������������this.root�������ؽ�㡣

    //����xԪ����Ϊp������/�Һ��ӽ�㣬x!=null��p!=null��leftָ����/�Һ��ӣ�ȡֵΪtrue���󣩡�false���ң���
    //p��ԭ��/�Һ��ӳ�Ϊx������/�Һ��ӣ����ز����xԪ�ؽ�㡣��x==null��p==null�������룬����null
    public BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x) {
        if (x == null || p == null)
            return null;
        if (left)                                 //����xΪp������/�Һ��ӣ����ز�����
            return p.left = new BinaryNode<T>(x, p.left, null);
        return p.right = new BinaryNode<T>(x, null, p.right);
    }

    //4.  ������ɾ������
    //ɾ��p������/��������leftָ����/��������ȡֵΪtrue���󣩡�false���ң�
    ////���ɾ������������5��̲�ûд
    public void remove(BinaryNode<T> p, boolean left) {
        if (p != null) {
            if (left) {
                System.out.println("ɾ��������" + toString(p.left));   //�ȸ�������������������������
                p.left = null;
            } else {
                System.out.println("ɾ��������" + toString(p.right));   //�ȸ�������������������������
                p.right = null;
            }
        }
    }
    ////˵����û�з���Ԫ�أ���Ϊɾ����һ���������кܶ�Ԫ�ء�

    public void clear()                          //ɾ�������������н�㣬ɾ�������
    {
        this.root = null;
    }


    //5. �������������ȵı����㷨
    public void preorder()                       //�ȸ��������������
    {
//        System.out.print("�ȸ����������������  ");
        preorder(this.root);                     //�����ȸ���������������ĵݹ鷽��
        System.out.println();
    }

    public void preorder(BinaryNode<T> p)       //�ȸ����������p���Ϊ�����������ݹ鷽��
    {
        if (p != null)                              //������������
        {
            System.out.print(p.data.toString() + " "); //���ȷ��ʵ�ǰ���Ԫ��
            preorder(p.left);                    //���ȸ��������p�����������ݹ���ã�����Ϊ����
            preorder(p.right);                   //���ȸ��������p�����������ݹ���ã�����Ϊ�Һ���
        }
    }
    //ע�⣺����private���������

    public void inorder()                        //�и��������������
    {
//        System.out.print("�и����������������  ");
        inorder(this.root);
        System.out.println();
    }

    public void inorder(BinaryNode<T> p)        //�и����������p���Ϊ�����������ݹ鷽��
    {
        if (p != null) {
            inorder(p.left);                     //�и��������p�����������ݹ����
            System.out.print(p.data.toString() + " ");
            inorder(p.right);                    //�и��������p�����������ݹ����
        }
    }

    public void postorder()                      //����������������
    {
//        System.out.print("������������������  ");
        postorder(this.root);
        System.out.println();
    }

    public void postorder(BinaryNode<T> p)      //������������p���Ϊ�����������ݹ鷽��
    {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString() + " ");  //����ʵ�ǰ���Ԫ��
        }
    }

    //��˼����6-2�� ����5��ϰ����
    public String toString()           //�����ȸ�����������������н��������ַ������������������
    {
        return "�ȸ����������������" + toString(this.root);
    }

    public String toString(BinaryNode<T> p)     //�����ȸ����������pΪ�������������ַ������ݹ鷽��
    {
        if (p == null)
            return "��";                         //������������
        return p.data.toString() + " " + toString(p.left) + toString(p.right);
    }

    //��ʵ����6-1�� ����5��ϰ���𡿸Ĵ�
    public int size()                            //���ض������Ľ����
    {
        return size(this.root);
    }

    public int size(BinaryNode<T> p)            //������p���Ϊ���������Ľ����
    {
        if (p == null)
            return 0;
        return 1 + size(p.left) + size(p.right);
    }

    //��ʵ����6-1���μ��⣬����5��ϰ����ûд
    public int height()                          //���ض������ĸ߶�
    {
        return height(this.root);
    }

    public int height(BinaryNode<T> p)          //������p���Ϊ���������߶ȣ�����������
    {
        if (p == null)
            return 0;
//        int lh = height(p.left);                 //�����������ĸ߶�
//        int rh = height(p.right);                //�����������ĸ߶�
//        return (lh>=rh) ? lh+1 : rh+1;           //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
        return Math.max(height(p.left), height(p.right)) + 1; //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
    }

    //6. ���������
    //��2�� �������������ȸ����б�ʾ
//    public BinaryTree(T[] prelist)               //�Ա������������ȸ�����������й��������
//    {
//        this.root = create(prelist);
//    }
//
//    //�Դ�i��ʼ�ı������������ȸ����У�����һ����prelist[i]Ϊ�������������������ĸ���㡣
//    //�ݹ��㷨�ȴ�������㣬�ٴ�����������������
//    private int i = 0;
//
//    private BinaryNode<T> create(T[] prelist) {
//        BinaryNode<T> p = null;
//        if (i < prelist.length) {
//            T elem = prelist[i++];
//            if (elem != null)                       //����elem!="��"����ΪT��һ����String
//            {
//                p = new BinaryNode<T>(elem);     //����Ҷ�ӽ��
//                p.left = create(prelist);        //����p�����������ݹ���ã�ʵ�ʲ�������ʽ������ͬ
//                p.right = create(prelist);       //����p�����������ݹ���ã�ʵ�ʲ�������ʽ������ͬ
//            }
//        }
//        return p;
//    }
    //����6.1��  �������Ĺ��졢���������롣


    //��˼����6-3�������ϰ����
    public BinaryTree(BinaryTree<T> bitree)      //�������췽�������
    {
        this.root = copy(bitree.root);
    }

    //������p�����Ӷ������������½��Ӷ������ĸ���㡣
    //�㷨�ȴ�������㣬�ٴ�����������������
    public BinaryNode<T> copy(BinaryNode<T> p) {
        BinaryNode<T> q = null;
        if (p != null) {
            q = new BinaryNode<T>(p.data);
            q.left = copy(p.left);               //�������������ݹ����
            q.right = copy(p.right);             //�������������ݹ����
        }
        return q;                                //���ؽ��������ĸ����
    }

    //7.  �������Ĺ�����ʾ
    //��1�� ������ʾ
    //��4��
    public void printGenList()                   //����������Ĺ�����ʾ�ַ���
    {
        System.out.print("�������Ĺ�����ʾ��");
        printGenList(this.root);
        System.out.println();
    }

    //�����p���Ϊ����һ�������Ĺ�����ʾ�ַ������ȸ�����������ݹ��㷨
    public void printGenList(BinaryNode<T> p) {
        if (p == null)                              //����������
            System.out.print("��");              //������������
        else {
            System.out.print(p.data.toString()); //���ʵ�ǰ���
            if (p.left != null || p.right != null)    //��Ҷ�ӽ�㣬������
            {
                System.out.print("(");
                printGenList(p.left);            //���p�����������ݹ����
                System.out.print(",");
                printGenList(p.right);           //���p�����������ݹ����
                System.out.print(")");
            }
        }
    }

    //��5��
    public String toGenListString()              //���ض������Ĺ�����ʾ�ַ���
    {
        return "�������Ĺ�����ʾ��" + toGenListString(this.root);
    }

    //������p���Ϊ����һ�������Ĺ�����ʾ�ַ������ȸ�����������ݹ��㷨
    public String toGenListString(BinaryNode<T> p) {
        if (p == null)
            return "��";                          //���ؿ��������
        if (p.left == null && p.right == null)         //p��Ҷ�ӽ��(p.isLeaf())
            return p.data.toString();
        return p.data.toString() + "(" + toGenListString(p.left) + "," + toGenListString(p.right) + ")";
    }
    //����6.2�� �������Ĺ�����ʾ��


    //8��ʹ��ջ����������
//    public void preorderTraverse()               //�ȸ���������������ķǵݹ��㷨
//    {
//        System.out.print("�ȸ����������������ʹ��ջ����");
//        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>(); //������ջ
//        BinaryNode<T> p = this.root;
//        while(p!=null || !stack.isEmpty())       //p�ǿջ�ջ�ǿ�ʱ    ////������for���
//        {
//            if(p!=null)
//            {
//                System.out.print(p.data+" ");    //���ʽ��
//                stack.push(p);                   //p�����ջ
//                p=p.left;                        //����������
//            }
//            else                                 //pΪ����ջ�ǿ�ʱ
//            {
//                System.out.print("�� ");
//                p=stack.pop();                   //pָ���ջ���
//                p=p.right;                       //����������
//            }
//        }
//        System.out.println("��");
//    }
//
//    //��˼����6-5��
    public void inorderTraverse()                //�и���������������ķǵݹ��㷨
    {
        System.out.print("�и����������������ʹ��ջ����");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //����һ����ջ
        BinaryNode<T> p = this.root;
        while (p != null || !stack.isEmpty())       //p�ǿջ�ջ�ǿ�ʱ
        {
            if (p != null) {
                stack.push(p);                   //p�����ջ
                p = p.left;                        //����������
            } else                                 //pΪ����ջ�ǿ�ʱ
            {
                System.out.print("�� ");
                p = stack.pop();                   //pָ���ջ���
                System.out.print(p.data + " ");    //���ʽ��
                p = p.right;                       //����������
            }
        }
        System.out.println("��");
    }
//
//
//    //9. �������Ĳ�α���
//    //��5��̲�д���㷨ͬ���Ĳ�α�����ͼ��һ�ι������������������������
//    public void levelorder()                    //����α���������
//    {
//        System.out.print("��α�����������  ");
//        if(this.root==null)
//            return;
//        //�¾䴴���ն��У����ж��е�Ԫ�������Ƕ��������BinaryNode<T>
////        Queue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>();
//        Queue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //��ʽ����
//        que.add(this.root);                      //��������
//        while(!que.isEmpty())                    //�����в���ʱѭ��////�ö��в�����Ϊѭ�����������е���
//        {
//            BinaryNode<T> p=que.poll();          //pָ����ӽ��////�����пշ���null
//            System.out.print(p.data+ " ");       //���ʳ��ӽ��p
//            if(p.left!=null)
//                que.add(p.left);                 //p�����ӽ�����
//            if(p.right!=null)
//                que.add(p.right);                //p���Һ��ӽ�����
//        }
//        System.out.println();
//    }
//    //ע�⣺���ж�����������ͼ�Ĳ�α����㷨Ҫ�ػ��ˣ��������ӡ�
//
    //10���Բ�α������й�����ȫ������
    //�����Բ�α�������levellist�������ȫ������
//    public static <T> BinaryTree<T> createComplete(T[] levellist) {
//        BinaryTree<T> bitree = new BinaryTree<T>();
//        bitree.root = create(levellist, 0);
//        return bitree;
//    }
//
//    //������levellist[i]Ϊ�������������������ĸ����
//    public static <T> BinaryNode<T> create(T[] levellist, int i) {
//        BinaryNode<T> p = null;
//        if (i < levellist.length) {
//            p = new BinaryNode<T>(levellist[i]);           //����Ҷ�ӽ��
//            p.left = create(levellist, 2 * i + 1);             //����p��������
//            p.right = create(levellist, 2 * i + 2);            //����p��������
//        }
//        return p;
//    }
//
//

    //TODO:�Ա������������ȸ�����������й����������ʹ��ջ----------------------------------------------------------------------------------------------------------------------------------------
    //TODO��boolean leftChild
    public BinaryTree(T[] prelist) {
        Stack<BinaryNode> stack = new SeqStack<>(prelist.length);
        if (prelist[0] != null) {
            this.root = new BinaryNode<T>(prelist[0]);
            stack.push(this.root);
            boolean leftChild = true;
            for (int i = 1; i < prelist.length; i++) {
                if (prelist[i] != null) {
                    BinaryNode currentNode = new BinaryNode(prelist[i]);
                    if (leftChild) {//��Ϊջ��������
                        stack.peek().left = currentNode;
                        stack.push(currentNode);
                    } else {//��Ϊջ��������
                        stack.pop().right = currentNode;
                        stack.push(currentNode);
                        leftChild = true;
                    }
                } else {
                    if (leftChild) {
                        leftChild = false;
                    } else {    //Ҷ�ӽڵ㣬ջ����ջ
                        stack.pop();
                    }

                }


            }
        } else this.root = null;

    }

    //TODO:�ж�һ�ö������Ƿ�Ϊ��ȫ��������ʹ�ö���----------------------------------------------------------------------------------------------------------------------------------------
    public static <T> boolean isComplete(BinaryTree<T> bitree) {
        if (bitree.root == null) {
            return true;
        }
        Queue<BinaryNode> queue = new LinkedQueue<>();
        queue.add(bitree.root);
        BinaryNode primeNode;
        while (!queue.isEmpty()) {          //�����д�������Ҷ�ӽ��
            primeNode = queue.peek();
            if (primeNode.left != null && primeNode.right != null) {    //������׽�������Һ���
                queue.add(primeNode.left);
                queue.add(primeNode.right);
                queue.poll();       //�ýڵ����
            } else if (primeNode.left != null) {    //������׽ڵ�ֻ������
                queue.add(primeNode.left);
                queue.poll();       //�ýڵ����
                break;
            } else if (primeNode.right == null) {   //���׽ڵ�ΪҶ�ӽ��
                break;
            } else return false;
        }

        while (!queue.isEmpty()) {      //�ж϶����еĽ���Ƿ�ΪҶ�ӽ��
            primeNode = queue.poll();
            if (!primeNode.isLeaf()) {
                return false;
            }
        }
        return true;
    }

    //TODO:�ݹ飬������й�����ȫ������----------------------------------------------------------------------------------------------------------------------------------------
    public static <T> BinaryTree<T> createComplete(T[] levellist) {
        if (levellist.length == 0) {
            return null;
        }
        BinaryTree completeTree = new BinaryTree();
        completeTree.root = createComplete(levellist, 0);
        return completeTree;
    }

    public static <T> BinaryNode<T> createComplete(T[] levellist, int i) {
        if (i >= levellist.length) {
            return null;
        } else {
            BinaryNode<T> p = new BinaryNode(levellist[i]);
            p.left = createComplete(levellist, 2 * i + 1);
            p.right = createComplete(levellist, 2 * i + 2);
            return p;
        }
    }


    //------------------------------------------------------------------------------------------------------------------------------------------
//    public BinaryTree<T> create(T[] inlist, T[] postlist) {
//        if (inlist == null || postlist == null)
//            return null;
//        this.root = create(inlist, postlist, postlist.length - 1, 0, inlist.length - 1);
//        return this;
//    }
//
//    public BinaryNode<T> create(T[] inlist, T[] postlist, int postlast, int infirst, int inlast) {
//        if (infirst > inlast) {
//            return null;
//        }
//        BinaryNode<T> childroot = new BinaryNode<T>(postlist[postlast]);
//        int i = 0;
//        while (!inlist[i].equals(childroot.data)) {
//            i++;
//        }
//        System.out.println((postlast - (inlast - i) - 1) + ",");
//        childroot.left = create(inlist, postlist, postlast - (inlast - i) - 1, infirst, i - 1);
//        childroot.right = create(inlist, postlist, postlast - 1, i + 1, inlast);
//        return childroot;
//    }


//    public static void main(String[] args) {
//        BinaryTree a = new BinaryTree();
//        a.insert(1);
//        a.insert(a.root, true, 3);
//        a.insert(a.root, false, 3);
//
//        BinaryTree b = new BinaryTree();
//        b.insert(0);
//        b.insert(b.root, true, 1);
//        b.insert(b.root, false, 1);
//        b.insert(b.root.left, true, 1);
//        b.insert(b.root.left, false, 1);
//        b.insert(b.root.right, true, 1);
//        b.insert(b.root.right, false, 1);
//        b.preorder();
//        b.inorder();
//        b.postorder();
//        System.out.println(a.toString(a.root));
//        System.out.println(b.toString(b.root.left));
//        System.out.println(b.isComplete(b));
//
//        String inlistvalue[] = {"4", "2", "5", "1", "6", "3", "7"};
//        String postlistvalue[] = {"4", "5", "2", "6", "7", "3", "1"};
//        BinaryTree treetest = new BinaryTree();
//        treetest.create(inlistvalue, postlistvalue);
//        treetest.preorder();
//        String test[] = {"0", "1", "2", "3", "4", "5", "6"};
//        BinaryTree test1 = createComplete(test);
//        System.out.print("���Ƿָ���");
//        System.out.print(test1.toString());
//        String prelist[] = {"0", "1", "3", "^", "^", "4", "^", "^", "2", "^", "^"};
//        BinaryTree testtree2 = new BinaryTree(prelist);
//        System.out.printf(testtree2.toString());
//
//
//    }


}
////@author��Yeheya��2016-1-22��2019��10��13�գ�2020��2��16��