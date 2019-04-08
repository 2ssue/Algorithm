import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 1; i <= num; i++) {
			if (checking(i)) cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
	static boolean checking (int i) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		while(true) {
			arr.add(i % 10);
			i /= 10;
			if (i == 0) break;
		}
		Collections.reverse(arr);
		
		if (arr.size() < 3) return true;
		else
			if ((arr.get(0)-arr.get(1)) == (arr.get(1)-arr.get(2))) return true;
		
		return false;
	}
}