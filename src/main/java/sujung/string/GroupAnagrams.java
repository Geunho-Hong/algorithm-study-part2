package sujung.string;

import java.util.*;

public class GroupAnagrams {

    /**
     * return the anagram groups in any order
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strarr = str.toCharArray();
            Arrays.sort(strarr);
            String reStr = String.valueOf(strarr);

            map.computeIfAbsent(reStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
