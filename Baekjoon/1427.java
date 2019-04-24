import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String[] inputNum = sc.nextLine().split("");
		
		for(int i = 0; i < inputNum.length; i++) {
			int nMaxIdx = i;
			for(int j = i + 1; j < inputNum.length; j++) {
				if(Integer.parseInt(inputNum[j]) > Integer.parseInt(inputNum[nMaxIdx]))
					nMaxIdx = j;
			}
			String swap = inputNum[i];
			inputNum[i] = inputNum[nMaxIdx];
			inputNum[nMaxIdx] = swap;
		}
		
		for(String i:inputNum) {
			System.out.print(i);
		}
	}
}