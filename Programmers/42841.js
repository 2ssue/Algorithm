function solution(baseball) {
  let answer = 0;

  for (let i = 123; i < 988; i++) {
    if (isInvalidNumber(i)) continue;
    let possibleFlag = false;

    for (let proposal of baseball) {
      const [strike, ball] = baseballGame(proposal[0], i);

      if (proposal[1] !== strike || proposal[2] !== ball) {
        possibleFlag = false;
        break;
      }

      possibleFlag = true;
    }

    if (possibleFlag) answer++;
  }

  return answer;
}

function isInvalidNumber(numbers) {
  const numberArray = numbers.toString().split('');

  if (numberArray[1] === '0' || numberArray[2] === '0') return true;

  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (j === i) continue;
      if (numberArray[i] === numberArray[j]) return true;
    }
  }

  return false;
}

function baseballGame(proposal, answer) {
  const answerArray = answer.toString().split('');
  const proposalArray = proposal.toString().split('');

  return proposalArray.reduce(
    (result, number, index) => {
      if (number === answerArray[index]) {
        result[0]++;
        return result;
      }

      if (answerArray.includes(number)) {
        result[1]++;
        return result;
      }

      return result;
    },
    [0, 0],
  );
}
