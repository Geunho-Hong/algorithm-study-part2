package seungho.dfs_bfs;

public class Network_programmers {
    boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            if (!visit[i]) {
                answer++;
                dfs(i, computers);
            }
        }

        return answer;
    }

    public void dfs(int idx, int[][] computers) {
        if (visit[idx]) {
            return;
        }

        visit[idx] = true;
        for (int j = 0; j < computers[idx].length; j++) {
            if (idx != j && computers[idx][j] == 1) {
                dfs(j, computers);
            }
        }
    }
}
