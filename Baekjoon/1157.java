import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine().toUpperCase();
		char[] arrIn = input.toCharArray();
	 	int[] arrCnt = new int[26];
	 	ArrayList<Integer> arrMax = new ArrayList<Integer>();
	 	
	 	Arrays.fill(arrCnt, 0);
	 	
	 	for(int i = 0; i < arrIn.length; i++) {
	 		arrCnt[(int)arrIn[i]-65] ++;
	 	}
		
	 	for(int j = 0; j < 26; j++) {
	 		if ((arrCnt[j] > 0) && arrMax.size() == 0) arrMax.add(j);
	 		if (arrMax.size() > 0) {
		 		if (arrCnt[j] > arrCnt[arrMax.get(0)]) {
		 			arrMax.removeAll(arrMax);
		 			arrMax.add(j);
		 		} else if (arrCnt[j] == arrCnt[arrMax.get(0)])
		 			if (j != arrMax.get(0))
		 				arrMax.add(j);
	 		}
	 	}
	 	
	 	if (arrMax.size() > 1) bw.write("?");
	 	else {
	 		bw.write(arrMax.get(0) + 65);
	 	}
	 	
		bw.flush();
		bw.close();
	}
}