class Solution {
  public int[] solution(long n) {
      int[] answer = {};
      
      if((int)Math.log10(n)+1 > 0){
          answer = new int [(int)Math.log10(n)+1];
          for(int i=0;i<answer.length;i++){
              System.out.println((int)n);
              answer[i] = (int)(n%10);
              n /= 10;
              System.out.println(answer[i]);
          }
      }else{
          answer = new int[1];
          answer[0] = (int)n;
      }
      
      return answer;
  }
}