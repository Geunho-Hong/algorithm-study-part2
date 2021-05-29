package min.hash;

import java.util.HashMap;
import java.util.Hashtable;

public class Test {

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();

        Integer i1 = 1;
        String s1 = "aa";
        String s2 = "asdasd";

        System.out.println(i1.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
