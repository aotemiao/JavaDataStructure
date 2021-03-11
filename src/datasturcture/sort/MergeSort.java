package datasturcture.sort;

import static datasturcture.sort.Module.less;

public class MergeSort {
    public static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[aux.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if (a[mid].compareTo(a[mid + 1]) <= 0) return;//子数组已排序，跳过merge
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(a[i], a[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
