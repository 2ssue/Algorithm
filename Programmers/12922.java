class Solution {
  public String solution(int n) {
      String answer = "";
      int a,b;
      
      a = n/2;
      b = n%2;
      
      for(int i=0;i<a;i++)
          answer = answer + "¼ö¹Ú";
      if(b!=0)
          answer = answer + "¼ö";
      
      return answer;
  }
}