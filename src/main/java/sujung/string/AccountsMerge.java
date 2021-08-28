package sujung.string;

import java.util.*;

public class AccountsMerge {

    private static class UnionFind {
        private final Map<Integer, Integer> parentMap = new HashMap<>();

        int find(int x) {
            if (parentMap.get(x) == null || parentMap.get(x) == x) {
                return x;
            } else {
                parentMap.put(x, find(parentMap.get(x))); // 경로 압축
                return parentMap.get(x);
            }
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            parentMap.put(y, x);
        }
    }

    /**
     * 계정 통합
     * 1. 이메일 주소가 같으면 동일한 계정 소유로 간주한다.
     * 2. 이메일 주소가 다르면 같은 이름이더라도 다른 계정으로 간주한다.
     *
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UnionFind uf = new UnionFind();

        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (indexMap.containsKey(email)) {
                    int previousIndex = indexMap.get(email);
                    uf.union(previousIndex, i);
                } else {
                    indexMap.put(email, i);
                }
            }
        }


        Map<Integer, Set<String>> disjointSetMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int representativeIndex = uf.find(i);
            disjointSetMap.putIfAbsent(representativeIndex, new HashSet<>());

            Set<String> set = disjointSetMap.get(representativeIndex);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                set.add(accounts.get(i).get(j));
            }
        }


        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : disjointSetMap.entrySet()) {
            int originIndex = entry.getKey();

            List<String> temp = new ArrayList<>(entry.getValue());
            Collections.sort(temp);

            temp.add(0, accounts.get(originIndex).get(0));

            result.add(temp);
        }
        return result;
    }
}
