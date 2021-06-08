package min.hash;

import java.util.*;

import static java.util.stream.Collectors.*;

public class BestAlbum {

    public static final int COUNT_GENRES_KIND = 100;

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres = {"classic", "pop", "classic", "classic", "jazz", "pop", "Rock", "jazz"};
        int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};

        int[] result = solution(genres, plays);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(String[] genres, int[] plays) {
        int capacity = (int) (COUNT_GENRES_KIND * 1.5);
        Map<String, Integer> genresRankMap = new HashMap<>(capacity);
        Map<String, ArrayList<Song>> songMap = new HashMap<>(capacity);

        for (int i = 0; i < genres.length; i++) {
            String cGenres = genres[i];
            final int no = i;
            final int play = plays[i];

            genresRankMap.putIfAbsent(cGenres, 0);
            genresRankMap.computeIfPresent(cGenres, (key, value) -> value + play);

            songMap.putIfAbsent(cGenres, new ArrayList<>());
            songMap.computeIfPresent(cGenres, (key, value) -> {
                ArrayList<Song> songs = songMap.get(key);
                songs.add(Song.create(no, play));
                return songs;
            });
        }
        System.out.println("genresRankMap = " + genresRankMap);
        System.out.println("songMap = " + songMap);

        for (ArrayList<Song> songList : songMap.values()) {
            songList.sort((s1, s2) -> {
                if (s1.play == s2.play) { // 재생 횟수가 같으면
                    return s1.no - s2.no; // 고유번호가 낮은 것
                }
                return s2.play - s1.play; // 재생 횟수가 높은 것
            });
        }
        System.out.println("sorted songMap = " + songMap);

        LinkedHashMap<String, Integer> ranks = genresRankMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("ranks = " + ranks);

        ArrayList<Integer> resultList = new ArrayList<>();
        ranks.forEach((key, value) -> {
            ArrayList<Song> songs = songMap.get(key);
            Song song1 = songs.get(0);
            if (Objects.nonNull(song1))
                resultList.add(song1.no);

            if (songs.size() >= 2) {
                Song song2 = songs.get(1);
                if (Objects.nonNull(song2))
                    resultList.add(song2.no);
            }
        });

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Song {
        private final int no;
        private final int play;

        private Song(int no, int play) {
            this.no = no;
            this.play = play;
        }

        public static Song create(int no, int play) {
            return new Song(no, play);
        }

        @Override
        public String toString() {
            return "Song{" +
                    "no=" + no +
                    ", play=" + play +
                    '}';
        }
    }
}