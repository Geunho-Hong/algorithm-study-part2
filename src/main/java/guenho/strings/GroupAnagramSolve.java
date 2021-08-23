package guenho.strings;

import java.util.*;

public class GroupAnagramSolve {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> answer = new LinkedList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            /**
             * map 에 key 값이 있다면 list 값을 가져와서 add 한다
             */
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> tempLst = new LinkedList<>();
                tempLst.add(strs[i]);
                map.put(key, tempLst);
            }
        }
        // convert map to list
        return new ArrayList<List<String>>(map.values());
    }
}
