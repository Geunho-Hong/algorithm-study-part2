package guenho.strings;

import java.util.*;

// https://leetcode.com/problems/accounts-merge/
// 질문 필요

public class AccountMergeSolve {
    public static void main(String[] args) {

        List<List<String>> accountsLst = new LinkedList<>();

        accountsLst.add(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}));
        accountsLst.add(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}));
        accountsLst.add(Arrays.asList(new String[]{"Mary", "mary@mail.com"}));
        accountsLst.add(Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}));

        System.out.println(accountsMerge(accountsLst));

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }
}
