import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nTestCase = sc.nextInt();
		
		for(int i = 0; i < nTestCase; i++) {
			int nRow = sc.nextInt();
			int nCol = sc.nextInt();
			int nFloor = 0;
			int nWindow = 1;
			
			int nCustomer = sc.nextInt();
			
			if(nCustomer > nRow) {
				nWindow += nCustomer/nRow;
				if(nCustomer % nRow == 0) nWindow--;
				nCustomer %= nRow;
			}
			
			for(int j = 0; j < nCustomer; j++) {
				nFloor++;
			}
			
			if(nCustomer == 0) nFloor += nRow;
			
			nFloor *= 100;
			System.out.println(nFloor + nWindow);
		}
	}
}
