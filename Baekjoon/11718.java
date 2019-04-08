import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in); 
        String print;
        
        while(scan.hasNextLine()){
            print = scan.nextLine(); 
            System.out.println(print);
        }
	}
}
