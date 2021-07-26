package min.exhaustive_search;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    static int n = 4;

    static List<Integer> list;

    public static void main(String[] args) {
        list = new ArrayList<>(n);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        permutation(0);
    }

    static void permutation(int k) {
        if (k == n) {
            System.out.println(list);
        } else {
            for (int i = k; i < n; i++) {
                swap(k, i);
                permutation(k + 1);
                swap(k, i);
            }
        }
    }

    static void swap(int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

}
