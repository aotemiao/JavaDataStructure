package datasturcture.list;

import static datasturcture.list.SinglyList.isSorted;

public class SinglyListEx {
    public static void main(String[] args) {
        Integer[] list = new Integer[4];
        list[0] = 4;
        list[1] = 3;
        list[2] = 2;
        list[3] = 1;
        SinglyList<Integer> listAcs = new SinglyList<>(list);
        System.out.println(isSorted(listAcs, false)+"");
    }
}

