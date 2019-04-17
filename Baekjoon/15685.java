import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[][] curveInfo;
	static int[][] map = new int[101][101];
	static int[] nx = {0, 0, -1, 1};
	static int[] ny = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int nDragonCurve = sc.nextInt();
		curveInfo = new int[nDragonCurve][4];
		
		for(int i = 0; i < nDragonCurve; i++) {
			for(int j = 0; j < 4; j++) {
				curveInfo[i][j] = sc.nextInt();
			}
		}
		
		CreateCurve();
		System.out.println(cntSquare());
	}
	public static void CreateCurve() {
		Stack<Integer> fullStack = new Stack<>();
		Stack<Integer> oldStack = new Stack<>();
		Queue<Integer> newQueue = new LinkedList();
		
		for(int i = 0; i < curveInfo.length; i++) {
			int[] location = new int[2];
			
			location[1] = curveInfo[i][0]; //x
			location[0] = curveInfo[i][1]; //y
			
			map[location[0]][location[1]] = 1;
			int nDirection = curveInfo[i][2];
			fullStack.push(nDirection);
	
			for(int j = 0; j < curveInfo[i][3]; j++) {
				while(!(fullStack.isEmpty())) {
					nDirection = fullStack.pop();
					oldStack.push(nDirection);
					nDirection = (nDirection + 1) % 4;
					newQueue.offer(nDirection);
					
					if(fullStack.isEmpty()) {
						while(!(oldStack.isEmpty())) {
							fullStack.push(oldStack.pop());
						}
						while(!(newQueue.isEmpty())) {
							fullStack.push(newQueue.poll());
						}
						break;
					}
				}
			}
			
			Stack<Integer> newStack = new Stack<>();
			
			while(!(fullStack.isEmpty())) {
				newStack.push(fullStack.pop());
			}
			while(!(newStack.isEmpty())) {
				nDirection = newStack.pop();
				nextLine(location, nDirection);
				map[location[0]][location[1]] = 1;
			}
		}
	}
	public static void nextLine(int[] location, int nDirection) {
		switch(nDirection) {
		case 0:
			location[1] += 1;
			break;
		case 1:
			location[0] -= 1;
			break;
		case 2:
			location[1] -= 1;
			break;
		case 3:
			location[0] += 1;
			break;
		}
	}
	public static int cntSquare() {
		int nCnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1&& map[i+1][j+1] == 1)
					nCnt++;
			}
		}
		return nCnt;
	}
}