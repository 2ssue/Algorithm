import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int[] nInputNum = new int[2];
		
		for(int i = 0; i < 2; i++) {
			nInputNum[i] = sc.nextInt();
		}
		
		int[] nOutputNum = new int[2];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 2; j >= 0; j--) {
				nOutputNum[i] += (nInputNum[i] % 10) * Math.pow(10, j);
				nInputNum[i] /= 10;
			}
		}
		
		if(nOutputNum[0] > nOutputNum[1])
			System.out.println(nOutputNum[0]);
		else
			System.out.println(nOutputNum[1]);
	}
}