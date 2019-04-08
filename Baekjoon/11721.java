import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sInput = scan.nextLine();
		int arrLength;
		
		if (sInput.length()%10 == 0) arrLength = sInput.length()/10;
		else arrLength = sInput.length()/10 + 1;
		
		String[] arrOutput = new String[arrLength];
		
		for(int i = 0; i <arrLength; i++) {
			if (i*10 + 10 > sInput.length()) arrOutput[i] = sInput.substring(i*10);
			else arrOutput[i] = sInput.substring(i*10, i*10 + 10);
			System.out.println(arrOutput[i]);
		}
	}
}