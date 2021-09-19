package sujung.graph.bfs;

import java.util.ArrayDeque;

public class WordConversion {

    private static class Node {
        private String word;
        private int edgeLength;

        public Node(String word, int edgeLength) {
            this.word = word;
            this.edgeLength = edgeLength;
        }
    }

    /**
     * 단어 변환 규칙 : 한번에 하나의 알파벳만, words에 있는 단어로만 변환 가능하다.
     * begin에서 target으로 변환하고자 할 때 최소 몇 번의 과정을 거쳐 가능한가?
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        int result = 0;

        boolean[] visited = new boolean[length];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.word.equals(target)) {
                result = node.edgeLength;
                break;
            }
            for(int i=0; i<length; i++) {
                if(!visited[i] && isPossibleToConvert(node.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], node.edgeLength + 1));
                }
            }
        }
        return result;
    }

    private boolean isPossibleToConvert(String cur, String next) {
        int diff = 0;
        for(int i=0; i<cur.length(); i++) {
            if(cur.charAt(i) != next.charAt(i)) {
                diff++;
            }
        }
        return diff <= 1;
    }
}
