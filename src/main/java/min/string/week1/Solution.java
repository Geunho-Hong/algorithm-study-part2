package min.string.week1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> results = new Solution().accountsMerge(accounts);

        results.forEach(result -> result.forEach(System.out::println));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }

        for (List<String> account : accounts) {
            String p = find(account.get(1), parents);
            for (int i = 2; i < account.size(); i++)
                parents.put(find(account.get(i), parents), p);
        }

        for (List<String> account : accounts) {
            String p = find(account.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < account.size(); i++)
                unions.get(p).add(account.get(i));
        }

        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }

        return res;
    }

    private String find(String email, Map<String, String> parents) {
        return parents.get(email).equals(email) ?
                email : // 꺼낸 이메일이 자신의 이메일과 같으면 그대로 반환
                find(parents.get(email), parents);
    }


}
