package guenho.strings;

import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        List<List<String>> accountsLst = new LinkedList<>();

        accountsLst.add(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}));
        accountsLst.add(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}));
        accountsLst.add(Arrays.asList(new String[]{"Mary", "mary@mail.com"}));
        accountsLst.add(Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}));

        //accountsLst.add(Arrays.asList(new String[]{"Gabe", "Gabe0@m.co", "Gabe3@m.co","Gabe1@m.co"}));
        //accountsLst.add(Arrays.asList(new String[]{"Kevin", "Kevin3@m.co", "Kevin5@m.co","Kevin0@m.co"}));
        //accountsLst.add(Arrays.asList(new String[]{"Ethan", "Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"}));
        //accountsLst.add(Arrays.asList(new String[]{"Hanzo", "Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"}));
        //accountsLst.add(Arrays.asList(new String[]{"Fern", "Fern5@m.co","Fern1@m.co","Fern0@m.co"}));

        //System.out.println(accountsLst);
        System.out.println(accountsMerge(accountsLst));

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> accountsMergeLst = new LinkedList<>();

        for (int i = 1; i < accounts.size()-1; i++) {
            List<String> accountsLst = new LinkedList<>();

            if(i > 0) {

                boolean isFlag = false;
                String beforeKey = accounts.get(i).get(0);
                String currentKey = accounts.get(i+1).get(0);

                if(beforeKey.equals(currentKey)) {
                    // If key is equals, get idx String in value
                    for (int j = 0; j < accounts.get(i).size(); j++) {
                        String beforeEdm = accounts.get(i+1).get(j);
                        for (int k = 0; k < accounts.get(i).size(); k++) {
                            String curEdm = accounts.get(i).get(k);
                            if(beforeEdm.equals(curEdm)) {
                                // There is exist same key, same email
                                isFlag = true;
                            }
                        }
                    }
                }
                if(isFlag) {
                    Set<String> set = new HashSet<>();

                    for (int j = 0; j < accounts.get(i).size(); j++) {
                        for (int k = 0; k < accounts.get(i+1).size(); k++) {
                            set.add(accounts.get(i-1).get(j));
                            set.add(accounts.get(i).get(k));
                        }
                    }
                    for(String s : set) {
                        accountsLst.add(s);
                    }
                } else {
                    for (int j = 0; j < accounts.get(i).size(); j++) {
                        String value = accounts.get(i).get(j);
                        accountsLst.add(value);
                    }
                }

            } else {
                for (int j = 0; j < accounts.get(i).size(); j++) {
                    String value = accounts.get(i).get(j);
                    accountsLst.add(value);
                }
            }
            Collections.sort(accountsLst);
            accountsMergeLst.add(accountsLst);
        }

        return accountsMergeLst;
    }
}
