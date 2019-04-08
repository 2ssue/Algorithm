class Solution {
  public String solution(String s, int n) {
      String answer = "";
      char[] split = s.toCharArray();
      
      for(int i = 0;i<s.length();i++){
          if(split[i]==' '){
              answer += split[i];
          } 
          else{
                if(split[i]<=90 && split[i]+n>=97) split[i] -= 26;
                split[i] += n;
                if((split[i]>=65&&split[i]<=90)||(split[i]<=122&&split[i]>=97))
                    answer += split[i];
                else{
                    split[i] -= 26;
                    answer += split[i];
                }
          }
          System.out.println(split[i]);
      }
      
      return answer;
  }
}