package datasturcture.sort;

import static datasturcture.sort.Module.exch;

/**
 * @author aotemiao
 * @date 2021/3/13 12:47
 */
public class Quick3way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        Comparable v = a[lo];
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }//a[lo..lt-1] < v=a[lt..gt] < a[gt+1..hi]³ÉÁ¢
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
