import java.util.Scanner;

public class Main {
	static int nNum;
	static int nFirst;
	static int nSecond;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		nNum = sc.nextInt();
		int nCnt = 1;
		nFirst = 1;
		nSecond = 1;
		int nLoopCnt = 0;
		
		while(true) {
			if(cntCheck(nCnt)) return ;
			for(int i = 0; i < nLoopCnt; i++) {
				nCnt++;
				nFirst--;
				nSecond++;	
				if(cntCheck(nCnt)) return ;
			}
			
			nLoopCnt++;
			nCnt++;
			nSecond++;
			if(cntCheck(nCnt)) return ;
			
			for(int i = 0; i < nLoopCnt; i++) {
				nCnt++;
				nFirst++;
				nSecond--;
				if(cntCheck(nCnt)) return ;
			}
			
			nLoopCnt++;
			nCnt++;
			nFirst++;
			if(cntCheck(nCnt)) return ;
		}
	}
	public static boolean cntCheck(int nCnt) {
		if(nNum == nCnt) {
			System.out.println(nFirst + "/" + nSecond);
			return true;
		}
		else return false;
	}
}
