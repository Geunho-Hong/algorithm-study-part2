package guenho.graph.bfs;

public class ChangeWords {

    private static int depth = 0;
    private static int answer = 0;
    private static boolean[] visited;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        visited = new boolean[words.length];
        dfs(begin, target, words,0);
        System.out.println(answer);

    }

    private static int dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return answer;
        }

        for (int i = 0; i < words.length; i++) {
            int sameCnt = 0;

            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    sameCnt++;
                }
            }

            if (sameCnt == words[i].length() - 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, cnt +1);
                visited[i] = false;
            }
        }
        return answer;
    }

}
