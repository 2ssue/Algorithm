import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num, rst, tmp;
		
		num = scan.nextInt();
		tmp = num;
		
		rst = num/5;
		
		if (num%5 != 0) {
			tmp -= rst*5;
			if (tmp%3 == 0) rst += tmp/3;
			else {
				if (rst == 0) rst = -1;
				else {
					while(true) {
						if (num==tmp) break;
						rst -= 1;
						tmp += 5;
						if (tmp%3 == 0) {
							rst += tmp/3;
							break;
						}
					}
					if (rst == 0) rst = -1;
				}
			}
		}
		System.out.println(rst);
	}
}