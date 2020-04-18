function solution(answers) {
  const mathHaters = [
    {
      correct: 0,
      answerPattern: [1, 2, 3, 4, 5],
    },
    {
      correct: 0,
      answerPattern: [2, 1, 2, 3, 2, 4, 2, 5],
    },
    {
      correct: 0,
      answerPattern: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
    },
  ];

  caculateScore(answers, mathHaters);

  const maxScoreStudents = mathHaters.reduce(
    (maxScoreStudent, mathHater, studentNumber) => {
      const maxScore = mathHaters[maxScoreStudent[0] - 1].correct;

      if (studentNumber === 0) {
        return maxScoreStudent;
      } else if (mathHater.correct > maxScore) {
        maxScoreStudent = [studentNumber + 1];
      } else if (mathHater.correct === maxScore) {
        maxScoreStudent.push(studentNumber + 1);
      }

      return maxScoreStudent;
    },
    [1],
  );

  return maxScoreStudents;
}

function caculateScore(answers, mathHaters) {
  return answers.forEach((answer, number) => {
    mathHaters.forEach((mathHater) => {
      if (
        mathHater.answerPattern[number % mathHater.answerPattern.length] ===
        answer
      ) {
        mathHater.correct += 1;
      }
    });
  });
}
