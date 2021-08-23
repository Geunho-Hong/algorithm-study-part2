package guenho.strings;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static Set<Set<String>> groupAnagrams(String[] strs) {
        Set<Set<String>> resultLst = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            String curStr = strs[i];
            List<String> list = new LinkedList<>();
            Set<String> set = new TreeSet<>();

            for (int j = 0; j < strs.length; j++) {
                if (i != j) {
                    boolean isCheck = true;
                    String compareStr = strs[j];

                    for (int k = 0; k < curStr.length(); k++) {
                        if(!isCheck) {
                            break;
                        }
                        for (int l = 0; l < compareStr.length(); l++) {
                            if (curStr.charAt(k) == compareStr.charAt(l)) {
                                isCheck = true;
                                break;
                            } else {
                                isCheck = false;
                            }
                        }
                    }

                    set.add(curStr);

                    if (isCheck) {
                        set.add(compareStr);
                        System.out.println("list = " + list.toString());
                        continue;
                    }
                }
                System.out.println("set = " + set.toString());
            }
            resultLst.add(set);
        }
        System.out.println("resultLst = " + resultLst.toString());
        return resultLst;
    }
}
