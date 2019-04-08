import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String snum = scan.nextLine();
		String[] sNumber = new String[num];
		int sum = 0;
		
		sNumber = snum.split("");
		
		for(int i = 0;i < num; i++) {
			sum += Integer.parseInt(sNumber[i]);
		}
		
		System.out.println(sum);
	}
}