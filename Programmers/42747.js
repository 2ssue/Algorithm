function solution(citations) {
  citations.sort((a, b) => b - a);

  const maxCitation = citations[0];
  let papers = 0;

  for (let hIndex = maxCitation; hIndex >= 0; hIndex--) {
    if (citations[papers] >= hIndex && papers < hIndex) {
      papers += 1;
    }

    if (papers === hIndex) {
      return hIndex;
    }
  }
}
