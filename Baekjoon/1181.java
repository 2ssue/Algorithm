import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nWordNum = Integer.parseInt(sc.nextLine());
		
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < nWordNum; i++) {
			set.add(sc.nextLine());
		}
		
		List<String> words = new ArrayList<String>(set);
		
		Collections.sort(words, new Comparator<String>() {
			public int compare(String str1, String str2) {
				if(str1.length() == str2.length()) {
					return str1.compareToIgnoreCase(str2);
				}else {
					return str1.length() - str2.length();
				}
			}
		});
		
		for(String out: words) {
			System.out.println(out);
		}
	}
}