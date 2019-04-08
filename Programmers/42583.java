import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int sum(int[] arr, int idx1, int idx2){
        int sum = 0;
        
        for(int i = idx1; i <= idx2; i++){
            sum += arr[i];    
        }
        
        return sum;
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int second = 0;
        
        Queue que = new LinkedList();
        int[] delay = new int[truck_weights.length];
        int front = 0;
        int rear = 0;
        
        que.offer(truck_weights[0]);
        second++;
        delay[0]++;
        
        while((!que.isEmpty())){
            second++;
            for(int i = front; i <= rear; i++){
                delay[i]++;
                if(delay[i] > bridge_length){
                    que.poll();
                    front++;
                }
            }
            if (!(rear + 1 == truck_weights.length)){
                if((sum(truck_weights, front, rear) + truck_weights[rear + 1]) <= weight){
                    que.offer(truck_weights[++rear]);
                    delay[rear]++;
                }
            }
        }
        answer = second;
        
        return answer;
    }
}