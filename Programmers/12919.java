class Solution {
  public String solution(String[] seoul) {
      String answer = "";
      int pos = 0;
      
      for(int i=0;i<seoul.length;i++){
          if(seoul[i].indexOf("Kim") > -1)
              pos = i;
      }
      
      answer = "�輭���� " + Integer.toString(pos) + "�� �ִ�";
      
      return answer;
  }
}