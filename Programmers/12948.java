class Solution {
  public String solution(String phone_number) {
      String answer = "";
      int star_num =  0;
      
      star_num = phone_number.length()-4;
      
      for(int i=0;i<star_num;i++){
          answer = answer + "*";
      }
      
      answer = answer + phone_number.substring(star_num);
     
      return answer;
  }
}