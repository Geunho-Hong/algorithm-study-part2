import java.util.*;

class Music implements Comparable<Music> {
    private final String genre;
    private final int play;
    private final int index;

    public Music(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlay() {
        return play;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Music other) {
        // 내림차순 정렬
        return other.getPlay() - this.play;
    }
}


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 순서 정하기
        Map<String, Integer> genres_order = new LinkedHashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (genres_order.containsKey(genres[i])) {
                genres_order.put(genres[i], genres_order.get(genres[i]) + plays[i]);
            } else {
                genres_order.put(genres[i], plays[i]);
            }
        }
        genres_order = sortMapByValue(genres_order);

        // 장르별로 musicList 생성
        Map<String, List<Music>> musicList = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : genres_order.entrySet()) {
            String genre = entry.getKey();
            musicList.put(genre,new LinkedList<Music>());
        }
        // 장르별로 musicList 입력
        for (int i = 0; i < genres.length; i++){
            List<Music> musics = musicList.get(genres[i]);
            musics.add(new Music(genres[i],plays[i],i));
        }
        // 장르순서대로 정렬된 리스트 가져온후 정렬
        // 그 후 결과 값 입력
        List<Integer> find = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genres_order.entrySet()) {
            String genre = entry.getKey();
            List<Music> musics = musicList.get(genre);
            Collections.sort(musics);
            for (int i = 0; i < musics.size(); i++) {
                find.add(musics.get(i).getIndex());
                if(i == 1)
                    break;
            }
        }

        int[] answer = new int[find.size()];
        for (int i = 0; i < find.size(); i++) {
            answer[i] = find.get(i);
        }
        return answer;
    }

    public LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop" };
        int[] plays = {500, 600, 150, 800, 2500};

        Arrays.stream(s.solution(genres, plays)).forEach(System.out::println);

    }
}