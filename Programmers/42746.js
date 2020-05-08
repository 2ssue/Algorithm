function solution(numbers) {
  numbers.sort((a, b) => {
    const stringA = a.toString();
    const stringB = b.toString();
    const arrayA = [...stringA];
    const arrayB = [...stringB];

    for (let i = 0; i < arrayA.length; i++) {
      if (arrayB[i] === undefined) break;
      if (arrayA[i] != arrayB[i]) {
        return arrayA > arrayB ? -1 : 1;
      }
    }

    const paddStringA = stringA.padEnd(arrayB.length, arrayA[0]);
    const paddStringB = stringB.padEnd(arrayA.length, arrayB[0]);

    if (paddStringA - paddStringB === 0) {
      const startA = stringA + stringB;
      const startB = stringB + stringA;

      return startB - startA;
    }

    return paddStringB - paddStringA;
  });

  if (numbers[0] == '0') return '0';

  return numbers.join('');
}
