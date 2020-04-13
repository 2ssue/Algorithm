function solution(genres, plays) {
  const summaryGenres = genres.reduce((acc, cur, index) => {
    if (!acc[cur]) {
      acc[cur] = {
        totalPlay: 0,
        playList: [],
      };
    }

    acc[cur].totalPlay += plays[index];
    acc[cur].playList.push([index, plays[index]]);

    return acc;
  }, {});

  const summaryGenresList = Object.values(summaryGenres).sort(
    (genre1, genre2) => {
      return genre2.totalPlay - genre1.totalPlay;
    },
  );

  const answer = summaryGenresList.reduce((acc, genre) => {
    genre.playList.sort((play1, play2) => {
      return play2[1] - play1[1];
    });

    acc.push(genre.playList[0][0]);

    if (genre.playList.length > 1) {
      acc.push(genre.playList[1][0]);
    }

    return acc;
  }, []);

  return answer;
}
