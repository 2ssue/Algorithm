import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b;
		int[] rst = new int[5];
		
		a = scan.nextInt();
		b = scan.nextInt();
		
		rst[0] = a+b;
		rst[1] = a-b;
		rst[2] = a*b;
		rst[3] = a/b;
		rst[4] = a%b;
		
		for (int i = 0; i < rst.length; i++)
			System.out.println(rst[i]);
	}
}