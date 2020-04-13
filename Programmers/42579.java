import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

class Genre {
    public int totalPlay;
    public List<int[]> playList = new ArrayList<>();

    public Genre(int playCount, int[] playList) {
        this.totalPlay = playCount;
        this.playList.add(playList);
    }

    public void increaseTotalPlay(int playCount) {
        this.totalPlay += playCount;
    }

    public void addPlayList(int[] playList) {
        this.playList.add(playList);
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreSummary = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Genre genre = genreSummary.get(genres[i]);
            if (genre == null) {
                genreSummary.put(genres[i], new Genre(plays[i], new int[] { i, plays[i] }));
            } else {
                genre.increaseTotalPlay(plays[i]);
                genre.addPlayList(new int[] { i, plays[i] });
            }
        }

        List<Genre> genreList = new ArrayList(genreSummary.values());

        Collections.sort(genreList, new Comparator<Genre>() {
            public int compare(Genre genre1, Genre genre2) {
                return genre2.totalPlay - genre1.totalPlay;
            }
        });

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < genreList.size(); i++) {
            Genre genre = genreList.get(i);

            Collections.sort(genre.playList, new Comparator<int[]>() {
                public int compare(int[] play1, int[] play2) {
                    return play2[1] - play1[1];
                }
            });

            answer.add(genre.playList.get(0)[0]);

            if (genre.playList.size() > 1) {
                answer.add(genre.playList.get(1)[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}