class Solution {
  public long solution(long n) {
      long answer;

      if(Math.sqrt(n)%1 == 0)
          answer = (long)((int)(Math.sqrt(n)+1))*((int)(Math.sqrt(n)+1));
      else
         answer = -1;
      
      return answer;
  }
}