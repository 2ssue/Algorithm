import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for(int i = num; i > 0; i--) {
			for(int j = 0; j < num; j++) {
				if (j < num - i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println("");
		}
	}
}