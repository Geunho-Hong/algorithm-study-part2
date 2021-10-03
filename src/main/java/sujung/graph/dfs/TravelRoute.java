package sujung.graph.dfs;

import java.util.*;

public class TravelRoute {

    private List<Node> nodes;
    private List<String> route;
    private String[] result;

    private static class Node implements Comparable<Node> {
        private String departure;
        private String destination;
        private boolean visited;

        public Node(String departure, String destination) {
            this.departure = departure;
            this.destination = destination;
            this.visited = false;
        }

        @Override
        public int compareTo(Node o) {
            if(this.departure.equals(o.departure)) {
                return this.destination.compareTo(o.destination);
            }
            return this.departure.compareTo(o.departure);
        }
    }

    /**
     * 출발지-도착지 편도 항공권들이 주어질 때, 방문하는 공항 경로를 반환한다.
     * 최초 출발지는 ICN이고, 모든 항공권을 이용해야 한다. 모든 도시를 방문할 수 없는 경우는 주어지지 않는다. (오일러 서킷)
     * @param tickets
     * @return
     */
    public String[] solution(String[][] tickets) {
        result = null;
        route = new ArrayList<>();
        nodes = new ArrayList<>();
        for (String[] ticket : tickets) {
            nodes.add(new Node(ticket[0], ticket[1]));
        }
        Collections.sort(nodes);

        route.add("ICN");
        dfs(0, "ICN");
        return result;
    }


    private void dfs(int index, String prev) {
        if(result != null) return;
        if(index >= nodes.size()) {
            result = new String[route.size()];
            for(int i=0; i<route.size(); i++) {
                result[i] = route.get(i);
            }
            return;
        }
        for (Node node : nodes) {
            if(node.visited) continue;
            if(!prev.equals(node.departure)) continue;

            node.visited = true;
            route.add(node.destination);
            dfs(index + 1, node.destination);
            node.visited = false;
            route.remove(route.size() - 1);
        }
    }
}
