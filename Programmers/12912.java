class Solution {
  public long solution(int a, int b) {
      long answer = 0;
      int i, convert = 0;
      
      if(a > b){
          convert = a;
          a = b;
          b = convert;
      }
      for(i=a;i<b+1;i++){
        answer += i;    
      }
      
      return answer;
  }
}