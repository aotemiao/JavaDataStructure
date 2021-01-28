package datasturcture.sort;

import datasturcture.sort.Module;

import static datasturcture.sort.Module.exch;
import static datasturcture.sort.Module.less;

public class SelectionSort {
    public static void sort(Comparable[] a) {//ÉýÐò
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[i])) min = j;
            }
            exch(a,i,min);
        }

    }
}
