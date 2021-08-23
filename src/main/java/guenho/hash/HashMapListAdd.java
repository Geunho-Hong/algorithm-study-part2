package guenho.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapListAdd {
    public static void main(String[] args) {
        Map<String, List<String>> dataMap = new HashMap<>();
        List<String> names = new LinkedList<>();
        names.add("grayson");

        dataMap.put("grayson", names);

        /**
         * map 에 key 값이 있다면 list 값을 가져와서 add 한다
         */

        if (dataMap.containsKey("grayson")) {
            dataMap.get("grayson").add("test");
        }
        System.out.println("dataMap = " + dataMap.toString());
    }
}
