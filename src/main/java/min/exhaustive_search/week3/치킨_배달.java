package min.exhaustive_search.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 치킨_배달 {

    static final int HOME = 1;
    static final int SHOP = 2;

    static int N; // 2 <= N <= 50
    static int M; // 1 <= M <= 13

    static ArrayList<Point> homes = new ArrayList<>();
    static ArrayList<Point> shops = new ArrayList<>();
    static ArrayList<Point> picks = new ArrayList<>();

    static int resultDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        dfs(0);

        System.out.println(resultDistance);
    }

    static void dfs(int depth) {
        if (picks.size() == M) {
            int distance = 0;

            for (Point home : homes) {
                int homeDistance = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    Point pick = picks.get(j);
                    homeDistance = Math.min(homeDistance, Math.abs(home.x - pick.x) + Math.abs(home.y - pick.y));
                }
                distance += homeDistance;
            }

            resultDistance = Math.min(resultDistance, distance);
            return;
        }

        for (int i = depth; i < shops.size(); i++) {
            picks.add(shops.get(i));
            dfs(i + 1);
            picks.remove(picks.size() - 1);
        }
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);

            for (int i = 0; i < N; i++) {
                inputs = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(inputs[j]);
                    Point point = new Point(i, j);

                    if (input == HOME) homes.add(point);
                    else if (input == SHOP) shops.add(point);
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}