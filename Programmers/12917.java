class Solution {
  public String solution(String s) {
      String answer = "";
      char[] split = s.toCharArray();
      char temp = 0;
      int len = s.length();
      
      for(int i=0;i<len;i++){
          for(int j=i+1;j<len;j++){  
              if(split[i]<split[j]){
                  temp = split[j];
                  split[j] = split[i];
                  split[i] = temp;
              }
          }
          answer += split[i];
      }
      
      return answer;
  }
}