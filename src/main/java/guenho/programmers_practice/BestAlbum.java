package guenho.programmers_practice;

// https://programmers.co.kr/learn/courses/30/lessons/42579

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));
    }

    private static int[] solution(String[] genres, int[] plays) {

        int[] answer = {};
        Song[] genreList = new Song[genres.length];

        List<Integer> answerList = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genreList[i] = new Song(genre, play, i, map.get(genre));
        }

        Arrays.sort(genreList, new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if (o1.totalPlays > o2.totalPlays) {
                    return -1;
                } else if (o1.totalPlays == o2.totalPlays) {
                    if (o1.plays > o2.plays) {
                        return -1;
                    } else if(o1.plays == o2.plays) {
                        return o1.id - o2.id;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });

        int genreCnt =0;

        for (int i = 1; i < genreList.length; i++) {
            Song prevGenre = genreList[i-1];
            Song curGenre = genreList[i];

            if(prevGenre.genre.equals(curGenre.genre)) {
                genreCnt ++;
            } else if(!prevGenre.genre.equals(curGenre.genre)) {
                genreCnt = 0;
            }

            if(genreCnt > 3) {
                continue;
            }

            answerList.add(prevGenre.id);

            System.out.println("genreCnt = " + genreCnt);
            System.out.println("prevGenre = " + prevGenre.toString());
            System.out.println("curGenre = " + curGenre.toString());
        }


        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }


    private static class Song {

        String genre;
        int plays;
        int id;
        int totalPlays;

        public Song(String genre, int plays, int id, int totalPlays) {
            this.genre = genre;
            this.plays = plays;
            this.id = id;
            this.totalPlays = totalPlays;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "genre='" + genre + '\'' +
                    ", plays=" + plays +
                    ", id=" + id +
                    ", totalPlays=" + totalPlays +
                    '}';
        }
    }

}
