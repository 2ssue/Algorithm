import java.util.Scanner;

public class Main {
	static String[][] sAlphabet = {
			{"A","B","C"},
			{"D","E","F"},
			{"G","H","I"},
			{"J","K","L"},
			{"M","N","O"},
			{"P","Q","R","S"},
			{"T","U","V"},
			{"W","X","Y","Z"}};
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nSecond = 0;
		String[] sInput = sc.nextLine().split("");
		
		for(int i = 0; i < sInput.length; i++) {
			nSecond += Executetime(sInput[i]);
		}
		
		System.out.println(nSecond);
	}
	public static int Executetime(String strAlphabet) {		
		for(int i = 0; i < 8; i++) {
			for(String sAlpha:sAlphabet[i]) {
				if(strAlphabet.equals(sAlpha)) {
					return i+3;
				}
			}
		}
		return 0;
	}
}