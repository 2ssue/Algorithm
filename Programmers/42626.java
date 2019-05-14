import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        
        for(int i:scoville) {
        	que.offer(i);
        }
        
        while(!(que.isEmpty())) {
        	if(que.peek() < K) {
        		if(que.size() < 2) {
        			answer = -1;
        			break;
        		}
        		que.offer(que.poll() + que.poll() * 2);
        	}else break;
        	answer++;
        }
        
        return answer;
    }
}