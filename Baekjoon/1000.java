import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int result = scan.nextInt();
		
		result += scan.nextInt();
		
		System.out.println(result);
	}
}