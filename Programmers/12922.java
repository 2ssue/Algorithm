class Solution {
  public String solution(int n) {
      String answer = "";
      int a,b;
      
      a = n/2;
      b = n%2;
      
      for(int i=0;i<a;i++)
          answer = answer + "����";
      if(b!=0)
          answer = answer + "��";
      
      return answer;
  }
}