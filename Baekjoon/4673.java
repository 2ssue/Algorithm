import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> arr = new ArrayList<Integer>();
		int arrcnt = 0, numcnt = 0;
		
		for(int i = 1; i <= 10000; i++) {
			if (arr.add(kaprekar(i)) == false) arr.remove(i);
		}
		
		Collections.sort(arr);
		int test;
		
		while(true) {
			numcnt++;
			if (numcnt == 10000) break;
			if (numcnt > arr.get(arrcnt)) {
				arrcnt++;
				numcnt--;
				continue;
			}
			if ((numcnt == arr.get(arrcnt))) {
				arrcnt++;
				continue;
			}
			bw.write(Integer.toString(numcnt)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int kaprekar(int num) {
		int sum = num;
		
		while(true) {
			sum += num%10;
			num /= 10;
			
			if (num == 0) break;
		}
		return sum;
	}
}