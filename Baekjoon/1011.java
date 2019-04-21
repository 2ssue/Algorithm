import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nTestCase= sc.nextInt();
		
		for(int i = 0; i < nTestCase; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int nDistance = end - start;
			int nCnt = 1;
			
			while(true) {
				if(Math.pow(nCnt, 2) > nDistance) break;
				nCnt++;
			}
			nCnt--;
			
			int nMove = nCnt * 2 - 1;
			int nMinor = nDistance - (int)Math.pow(nCnt, 2);
			
			nMove += Math.ceil((double)nMinor/(double)nCnt);

			System.out.println(Math.pow(2, 31));
		}
	}
}