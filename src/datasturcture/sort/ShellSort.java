package datasturcture.sort;

import static datasturcture.sort.Module.exch;
import static datasturcture.sort.Module.less;

public class ShellSort {
    public static void sort(Comparable[] a) {//升序
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {//将数组变为h有序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j++) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
