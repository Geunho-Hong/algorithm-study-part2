package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class ChickenDelivery {

    private static final int HOUSE = 1;
    private static final int CHICKEN = 2;

    private static int N, M;
    private static List<Point> houses;
    private static List<Point> chickenRestaurants;
    private static int result;

    private static class Point {
        private int x;
        private int y;
        private boolean selected;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.selected = false;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());

            result = Integer.MAX_VALUE;

            houses = new ArrayList<>();
            chickenRestaurants = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int value = parseInt(st.nextToken());
                    if (value == CHICKEN) {
                        chickenRestaurants.add(new Point(i, j));
                    }
                    if (value == HOUSE) {
                        houses.add(new Point(i, j));
                    }
                }
            }

            combination(0, 0);
            System.out.println(result);
        }
    }

    /**
     * 치킨 거리란 집과 치킨집의 거리 |r1-r2| + |c1-c2| 이며,
     * 도시의 치킨 거리는 모든 집의 치킨 거리의 합
     * 도시의 치킨거리가 가장 작아지는 M개의 치킨집을 선정한다.
     *
     * @param index
     * @param selected
     */
    private static void combination(int index, int selected) {
        if (selected >= M) {
            int totalDistance = computeTotalChickenDistance();
            result = Math.min(result, totalDistance);
            return;
        }
        if (index >= chickenRestaurants.size()) {
            return;
        }

        for (int i = index; i < chickenRestaurants.size(); i++) {
            Point p = chickenRestaurants.get(i);
            p.selected = true;
            combination(i + 1, selected + 1);
            p.selected = false;
        }
    }

    /**
     * 선정된 치킨집을 바탕으로 모든 집 치킨거리를 계산한다.
     *
     * @return
     */
    private static int computeTotalChickenDistance() {
        int totalDist = 0;

        for (Point housePoint : houses) {
            int minDist = Integer.MAX_VALUE;
            for (Point chickenPoint : chickenRestaurants) {
                if (!chickenPoint.selected) continue;
                int temp = Math.abs(housePoint.x - chickenPoint.x) + Math.abs(housePoint.y - chickenPoint.y);
                minDist = Math.min(minDist, temp);
            }
            totalDist += minDist;
        }

        return totalDist;
    }
}
