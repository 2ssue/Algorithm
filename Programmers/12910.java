class Solution {
  public int[] solution(int[] arr, int divisor) {
      int[] answer = {};
      int[] temp = new int[arr.length];
      int i = 0, j = 0, t = 0, a;
      
      for(i=0;i<arr.length;i++){
          if(arr[i]%divisor == 0){
              temp[j]=arr[i];
              j++;
          }
      }     
      
      if(j==0){
          answer = new int [j+1];
          answer[0] = -1;
      }
      else{
          answer = new int [j];
          for(i=0;i < j-1;i++){
              for(a=i+1;a<j;a++){
                if(temp[a]==0)
                   continue; 
                else if(temp[i]>temp[a]){
                    t = temp[i];
                    temp[i] = temp[a];
                    temp[a] = t;
                }
              }
          }
          for(i=0;i<j;i++)
              answer[i] = temp[i];
      }
      
      return answer;
  }
}