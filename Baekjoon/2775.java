import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nTestCase = sc.nextInt();
		int[][] apart = new int[15][15];
		
		for(int i = 0; i < 15; i++) {
			apart[i][0] = 1;
			apart[0][i] = i + 1;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				apart[i][j] = apart[i-1][j] + apart[i][j-1];
			}
		}
		
		for(int i = 0; i < nTestCase; i++) {
			int nFloor = sc.nextInt();
			int nRoom = sc.nextInt();
			
			System.out.println(apart[nFloor][nRoom - 1]);
		}
	}
}