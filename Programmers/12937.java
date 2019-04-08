class Solution {
  public String solution(int num) {
      int check = num%2;
      String answer = "";
      
      if(check==0)
          answer = "Even";
      else
          answer = "Odd";
      
      return answer;
  }
}