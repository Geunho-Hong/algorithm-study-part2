package min.string.week1;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            List<String> anagrams;
            if (groupMap.containsKey(key)) {
                anagrams = groupMap.get(key);
            } else {
                anagrams = new ArrayList<>();
                groupMap.put(key, anagrams);
            }
            anagrams.add(str);
        }

        List<List<String>> results = new ArrayList<>(groupMap.values());
//        groupMap.forEach((key, value) -> results.add(value));
        return results;
    }

}
