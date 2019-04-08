import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		int input = scan.nextInt();
		
		for(int i = 0; i < input; i++) {
			sum += i + 1;
		}
		
		System.out.println(sum);
	}
}