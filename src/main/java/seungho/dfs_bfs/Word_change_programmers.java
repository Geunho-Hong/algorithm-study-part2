package seungho.dfs_bfs;

public class Word_change_programmers {
    boolean[] visited;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin,target,words,0);
        if (answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            if(wordCheckCount(begin,words[i]) == 1){
                visited[i] = true;
                dfs(words[i],target,words,count+1);
                visited[i] = false;
            }
        }
    }

    public int wordCheckCount(String a, String b) { //글자 차이 카운트
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return count;
    }
}
