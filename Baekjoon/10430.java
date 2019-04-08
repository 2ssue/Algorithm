import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		int[] rst = new int[4];
		
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		
		rst[0] = (a+b)%c;
		rst[1] = (a%c + b%c)%c;
		rst[2] = (a*b)%c;
		rst[3] = (a%c * b%c)%c;
		
		for (int i = 0; i < rst.length; i++)
			System.out.println(rst[i]);
	}
}