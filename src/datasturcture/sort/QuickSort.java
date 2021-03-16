package datasturcture.sort;

import static datasturcture.sort.Module.exch;
import static datasturcture.sort.Module.less;

public class QuickSort {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);//todo:当数组太小时调用插入排序
        sort(a, lo, j - 1);
        sort(a, j, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;//todo:优化
            while (less(v, a[--j]));   //if (j == lo) break;比较元素不会比本身还小
            if (i >= j) break;
            exch(a, i, j);
        }
        return j;
    }
}
