package datasturcture.sort;

import static datasturcture.sort.Module.exch;
import static datasturcture.sort.Module.less;

public class InsertionSort {
    public static void sort(Comparable[] a) {//ÉýÐò
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j++) {
                exch(a, j, j - 1);
            }
        }
    }
}

