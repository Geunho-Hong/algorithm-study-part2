package guenho.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class TravelRoute {

    private static boolean[] visited;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};
        System.out.println(solution(tickets));
    }

    private static String[] solution(String[][] tickets) {
        String[] answer = {};

        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets[i].length; j++) {
                System.out.println(tickets[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }

    private static void bfs(int i) {
        Queue<Node> queue = new ArrayDeque<>();



    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
