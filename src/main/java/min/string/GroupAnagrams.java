package min.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            List<String> anagrams = null;
            if (groupMap.containsKey(key)) {
                anagrams = groupMap.get(key);
            } else {
                anagrams = new ArrayList<>();
                groupMap.put(key, anagrams);
            }
            anagrams.add(str);
        }

        List<List<String>> results = new ArrayList<>();
        groupMap.forEach((key, value) -> results.add(value));
        return results;
    }

}
