import java.util.Stack;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int rear = heights.length - 2;
        int pop = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < heights.length; i++){
            stack.push(heights[i]);
        }
        
        while(!(stack.isEmpty())){
            pop = stack.pop();
            for(int i = rear; i >= 0; i--){
                if(heights[i] > pop){
                    answer[rear + 1] = i + 1;
                    break;
                }
            }
            rear--;
        }
        return answer;
    }
}