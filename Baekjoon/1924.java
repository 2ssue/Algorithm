import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] fix_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] fix_day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int sum = 0;
		int month = scan.nextInt();
		int day = scan.nextInt();
		
		for(int i = 0; i < month - 1; i++)
			sum += fix_month[i];
		sum += day;
		sum %= 7;
		
		System.out.println(fix_day[sum]);
	}
}