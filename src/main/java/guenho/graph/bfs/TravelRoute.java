package guenho.graph.bfs;

import java.util.ArrayList;
import java.util.Collections;

public class TravelRoute {

    private static boolean[] visited;
    private static ArrayList<String> answer;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};
        System.out.println(solution(tickets));
    }

    public static String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs("ICN","ICN",0,tickets);
        Collections.sort(answer);

        return answer.get(0).split(" ");
    }


    private static void dfs(String now, String result, int depth, String[][] tickets) {
        // 사용 티켓 수가 같아진 경우
        if(depth == tickets.length) {
            answer.add(result);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(tickets[i][1],result + " " + tickets[i][1],depth+1,tickets);
                visited[i] = false;
            }
        }
    }

}
