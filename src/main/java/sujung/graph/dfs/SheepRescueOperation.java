package sujung.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class SheepRescueOperation {

    private static int N;
    private static long[] objects;
    private static List<Integer>[] adjacent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            initMap(br);

            long rescuer = dfs(1);
            System.out.println(rescuer);
        }
    }

    private static long dfs(int curIndex) {
        visited[curIndex] = true;
        long curObjects = objects[curIndex];
        if (adjacent[curIndex] != null) {
            for (int childIndex : adjacent[curIndex]) {
                if (!visited[childIndex]) {
                    long result = dfs(childIndex);
                    curObjects += result;
                }
            }
        }
        return Math.max(curObjects, 0);
    }

    private static void initMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        objects = new long[N + 1];
        visited = new boolean[N + 1];
        adjacent = (List<Integer>[]) new ArrayList[N + 1];

        objects[1] = 0;
        for (int i = 2; i <= N; i++) {
            String[] temp = br.readLine().split(" ");

            String type = temp[0];
            int number = Integer.parseInt(temp[1]) * ("W".equals(type) ? -1 : 1);
            objects[i] = number;

            if (adjacent[Integer.parseInt(temp[2])] == null) {
                adjacent[Integer.parseInt(temp[2])] = new ArrayList<>();
            }
            adjacent[Integer.parseInt(temp[2])].add(i);
        }
    }
}
