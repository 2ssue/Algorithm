import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> prog_que = new LinkedList<>();
        Queue<Integer> speed_que = new LinkedList<>();
        Queue<Integer> answer_que = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
        	prog_que.offer(progresses[i]);
        	speed_que.offer(speeds[i]);
        }
        
        int pollNum = 0;
        
        while(!(prog_que.isEmpty())) {
        	if(prog_que.peek() >= 100) {
        		prog_que.poll();
        		speed_que.poll();
        		pollNum++;
        		while(!(prog_que.isEmpty()) && prog_que.peek() >= 100) {
        			prog_que.poll();
        			speed_que.poll();
        			pollNum++;
        		}
        		answer_que.offer(pollNum);
        		pollNum = 0;
        	}
        	
        	int queSize = prog_que.size();
        	for(int i = 0 ; i < queSize; i++) {
	        	int prog = prog_que.poll();
	        	int speed = speed_que.poll();
	        	prog += speed;
	        	prog_que.offer(prog);
	        	speed_que.offer(speed);
        	}
        }
        
        int cnt = 0;
        answer = new int[answer_que.size()];
        
        while(!(answer_que.isEmpty())) {
        	answer[cnt] = answer_que.poll();
        	cnt++;
        }
        
        return answer;
    }
}