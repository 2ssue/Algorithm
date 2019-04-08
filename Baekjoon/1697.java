import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int MAX_VALUE = 100000;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int nSubin = sc.nextInt();
		int nBrother = sc.nextInt();
		
		boolean[] visited = new boolean[MAX_VALUE + 1];
		int[] dist = new int[MAX_VALUE + 1];
		int now = 0;
		
		Queue<Integer> que = new LinkedList();
		
		que.offer(nSubin);
		
		now = que.peek();
		visited[now] = true;
		dist[now] = 0;
		
		while(!(que.isEmpty())) {
			now = que.poll();
			
			if (now == nBrother) {
				que.clear();
				System.out.println(dist[now]);
			}
			
			if(now > 0 && visited[now-1]==false) {
				que.offer(now-1);
				visited[now-1] = true;
				dist[now-1] = dist[now] + 1;
			}
			if(now < MAX_VALUE && visited[now+1]==false) {
				que.offer(now+1);
				visited[now+1] = true;
				dist[now+1] = dist[now] + 1;
			}
			if(2*now <= MAX_VALUE && visited[2*now]==false) {
				que.offer(2*now);
				visited[2*now] = true;
				dist[2*now] = dist[now] + 1;
			}
		}
    }
}