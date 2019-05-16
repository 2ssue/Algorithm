import java.util.Stack;

class Solution {
    public int[] solution(int[] answers) {
    	int[] answer;
    	int[][] check = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
    	int[] correct = new int[3];
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < answers.length; j++) {
    			if(answers[j] == check[i][j%check[i].length]) correct[i]++;
    		}
    	}
    	
    	stack.push(0);
    	for(int i = 1; i < 3; i++) {
    		if(correct[stack.peek()] < correct[i]) {
    			stack.clear();
    			stack.push(i);
    		}else if(correct[stack.peek()] == correct[i]) {
    			stack.push(i);
    		}
    	}
    	
    	answer = new int[stack.size()];
    	int i = stack.size() - 1;
    	while(!(stack.isEmpty())) {
    		answer[i] = stack.pop() + 1;
    		i--;
    	}
    	
    	return answer;
    }
}