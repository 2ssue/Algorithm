class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	int answer = n;
    	int[] students = new int[n+1];
    	
    	for(int i = 0; i < lost.length; i++) {
    		students[lost[i]] = -1;
    	}
    	
    	for(int i = 0; i < reserve.length; i++) {
    		students[reserve[i]]++;
    	}
    	
    	for(int i = 0; i < reserve.length; i++) {
    		if(students[reserve[i]] > 0) {
    			if(students[reserve[i] - 1] < 0) {
        			students[reserve[i] - 1]++;
        			students[reserve[i]]--;
        			continue;
        		}
        		if(reserve[i] < n && students[reserve[i] + 1] < 0) { 
        			students[reserve[i] + 1]++;
        			students[reserve[i]]--;
        			continue;
        		}
    		}
    	}
    	
    	for(int i = 1; i < n+1; i++) {
    		if(students[i] < 0) answer--;
    	}
    	
    	return answer;
    }
}