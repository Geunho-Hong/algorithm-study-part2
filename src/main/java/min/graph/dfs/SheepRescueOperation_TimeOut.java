package min.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SheepRescueOperation_TimeOut {

    static int n;
    static Map<Integer, Island> map;
    static int totalSheepAmount;

    public static void main(String[] args) throws IOException {
        initMap();

        map.forEach((no, island) -> {
            if (island.existSheep() && !island.visited) // 섬에 양이 존재하면서 방문하지 않았으면 재귀
                island.visited = true;
                preyOnSheep(no, island.a);
        });

        System.out.println(totalSheepAmount);
    }

    static void preyOnSheep(int islandNo, int sheepAmount) {
        if (islandNo == 1) {
            totalSheepAmount += sheepAmount;
            return;
        }

        if (sheepAmount <= 0) {
            sheepAmount = 0;
        }

        Island cur = map.get(islandNo);

        if (cur.existWolf()) {
            sheepAmount -= cur.a;
        } else if (cur.existSheep() && !cur.visited) {
            sheepAmount += cur.a;
            cur.visited = true;
        }

        preyOnSheep(cur.p, sheepAmount);
    }

    static void initMap() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            map = new HashMap<>((int) (n * 1.5));

            for (int i = 2; i < n + 1; i++) {
                String[] strArr = br.readLine().split(" ");
                Island island = new Island(strArr[0].charAt(0), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]));
                map.put(i, island);
            }
        }
    }

    static class Island {
        char t;
        int a;
        int p;
        boolean visited;

        public Island(char t, int a, int p) {
            if (t != 'S' && t != 'W') {
                throw new IllegalArgumentException("섬에는 늑대 또는 양이 존재할 수 있습니다.");
            }

            this.t = t;
            this.a = a;
            this.p = p;
        }

        public int getAmount() {
            return this.a;
        }

        public boolean existSheep() {
            return t == 'S';
        }

        public boolean existWolf() {
            return t == 'W';
        }
    }

}