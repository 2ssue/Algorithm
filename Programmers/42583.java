import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public void increaseTime(Queue<Integer> time) {
        int queueSize = time.size();
        
        for(int i = 0; i < queueSize; i++) {
            time.offer(time.poll() + 1);
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
         
        int bridge_weight = 0;
        Queue<Integer> truck_time = new LinkedList<>();
        int idx = 0;
         
        while(idx < truck_weights.length) {
            answer++;
             
            int curTruck = truck_weights[idx];
             
            if(bridge_weight + curTruck <= weight) {
                idx++;
                bridge_weight += curTruck;
                truck_time.offer(0);
            }
             
            increaseTime(truck_time);
             
            if(truck_time.peek() == bridge_length) {
                bridge_weight -= truck_weights[idx - truck_time.size()];
                truck_time.poll();
            }
        }
         
        answer += bridge_length;
         
        return answer;
    }
}