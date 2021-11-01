package seungho.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;

public class Travel_route_programmers {
    ArrayList<String> list;
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN",0,"ICN",tickets);
        Collections.sort(list);


        return list.get(0).split(" ");
    }

    public void dfs(String start, int idx, String result, String[][] tickets) {
        if (idx == tickets.length) {
            list.add(result);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], idx + 1, result + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

}
