import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    
    public void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j - 1] > arr[j])
                    swap(arr, j-1, j);
            }
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue que = new LinkedList();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < priorities.length; i++){
            que.offer(priorities[i]);    
        }
        
        sort(priorities);
        
        for(int i = 0; i < priorities.length; i++){
            stack.push(priorities[i]);
        }
        
        while(!(que.isEmpty())){
            if(!(que.peek().equals(stack.peek()))){
                que.offer(que.poll());
                if(location == 0) location = que.size() - 1;
                else location--;
            }else{
                if(location != 0){
                    que.poll();
                    stack.pop();
                    answer++;
                    location--;
                }
                else{
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}