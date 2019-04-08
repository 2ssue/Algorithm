import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		int sum, cnt;
		String collect = "O";
		String[] quiz;
		
		for (int i = 0; i < testcase; i++) {
			sum = 0;
			cnt = 0;
			quiz = br.readLine().split("");
			for (int j = 0; j < quiz.length; j++) {
				if (quiz[j].equals(collect)) {
					cnt++;
				}else cnt = 0;
				sum += cnt;
			}
			bw.write(Integer.toString(sum)+"\n");
		}
		bw.flush();
		bw.close();
	}
}