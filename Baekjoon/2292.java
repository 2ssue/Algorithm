import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nNum = sc.nextInt();
		int nCnt = 0;
		
		while(true) {
			if(((3*nCnt*nCnt) + (3*nCnt) + 1) >= nNum) {
				System.out.println(nCnt + 1);
				break;
			}
			nCnt++;
		}
		
	}
}