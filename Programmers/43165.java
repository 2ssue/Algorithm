class Solution {
        public int solution(int[] numbers, int target) {
    	int answer = 0; 

    	answer = dfs(numbers, target, 0, 0);
    	
    	return answer;
    }
    public int dfs(int[] numbers, int target, int sum, int idx) {
    	int result = 0;
    	
    	if(idx == numbers.length) {
    		if(sum == target) return 1;
    		else return 0;
    	}else {
    		result = dfs(numbers, target, sum + numbers[idx], idx + 1) + dfs(numbers, target, sum + (numbers[idx] * - 1), idx + 1);
    	}
    	
    	return result;
    }
}