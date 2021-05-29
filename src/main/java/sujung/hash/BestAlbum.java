package sujung.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayCount = new HashMap<>();
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            songs.add(new Song(i, plays[i], genres[i]));
        }

        songs.sort((o1, o2) -> {
            if (o1.genre.equals(o2.genre)) {
                if (o1.playCount == o2.playCount) {
                    return o1.index - o2.index;
                }
                return o2.playCount - o1.playCount;
            }
            return genrePlayCount.get(o2.genre) - genrePlayCount.get(o1.genre);
        });


        Map<String, Integer> genreCount = new HashMap<>();
        List<Song> candidates = new ArrayList<>();

        for (Song song : songs) {
            int count = genreCount.getOrDefault(song.genre, 0);
            if (count < 2) {
                candidates.add(song);
                genreCount.put(song.genre, count + 1);
            }
        }

        int[] answers = new int[candidates.size()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = candidates.get(i).index;
        }
        return answers;
    }

    private static class Song {
        private final int index;
        private final int playCount;
        private final String genre;

        public Song(int index, int playCount, String genre) {
            this.playCount = playCount;
            this.index = index;
            this.genre = genre;
        }
    }

}
