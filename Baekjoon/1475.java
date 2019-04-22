import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String[] sRoomNum = sc.nextLine().split("");
		int[] nNum = new int[10];
		int nSet = 0;
		
		for(int i = 0; i < sRoomNum.length; i++) {
			int nCurrentNum = Integer.parseInt(sRoomNum[i]);
			if(nCurrentNum == 9) {
				if(nNum[6] < nNum[9]) nNum[6]++;
				else nNum[9]++;
			}else if(nCurrentNum == 6) {
				if(nNum[9] < nNum[6]) nNum[9]++;
				else nNum[6]++;
			}else {
				nNum[nCurrentNum]++;
			}
		}
		
		for(int i = 0; i < 10; i++) {
			if(nSet < nNum[i]) nSet = nNum[i];
		}
		
		System.out.println(nSet);
	}
}