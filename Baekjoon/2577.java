import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int[] num_cnt = new int[10];
		Arrays.fill(num_cnt, 0);
		
		int multiple = a*b*c;
		
		while(true){
			num_cnt[multiple%10]++;
			multiple /= 10;
			if (multiple == 0) break;
		}
		
		for(int i = 0; i < 10; i++) {
			bw.write(Integer.toString(num_cnt[i])+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}