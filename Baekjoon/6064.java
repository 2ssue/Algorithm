import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nTestCase = sc.nextInt();
		
		for(int i = 0; i < nTestCase; i++) {
			int[] input = new int[4];
			for(int j = 0; j < 4; j++) {
				input[j] = sc.nextInt();
			}
			
			int nCurrent = input[2];
			int nMax = lcm(input[0], input[1]);
			
			while(true) {
				int nX = nCurrent % input[0];
				int nY = nCurrent % input[1];
				
				if(nX == 0) nX = input[0];
				if(nY == 0) nY = input[1];
				
				if(nX == input[2] && nY == input[3]) break;
				
				nCurrent += input[0];
				
				if(nCurrent > nMax) {
					nCurrent = -1;
					break;
				}
				
			}
			
			System.out.println(nCurrent);
		}
	}
	public static int lcm(int a, int b) {
		return a * b/gcd(a,b);
	}
	public static int gcd(int a, int b) {
		int mod = a % b;
		while(mod > 0) {
			a = b;
			b = mod;
			mod = a % b;
		}
		return b;
	}
}