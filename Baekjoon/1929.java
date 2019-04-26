import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int nStart = sc.nextInt();
		int nEnd = sc.nextInt();
		
		boolean[] nNum = new boolean[nEnd + 1];
		
		nNum[0] = true;
		nNum[1] = true;
		
		for(int i = 2; i*i <= nEnd; i++) {
			for(int j = i*i; j <= nEnd; j += i)
				nNum[j] = true;
		}
		
		for(int i = nStart; i <= nEnd; i++) {
			if(nNum[i] == false) {
				System.out.println(i);
			}
		}
	}
}