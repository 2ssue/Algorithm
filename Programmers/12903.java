class Solution {
  public String solution(String s) {
    int TotalLength, delim = 0;
    String answer = "";
    
    TotalLength = s.length();
    delim = TotalLength/2;
    
    if(TotalLength%2 == 0)
        answer = s.substring(delim - 1, delim + 1);
    else
        answer = s.substring(delim, delim + 1); 
      return answer;
  }
}