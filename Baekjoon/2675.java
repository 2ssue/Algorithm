import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int repeat = Integer.parseInt(br.readLine());
		String[] testcase = new String[2];
		String[] text;
		String rst;
		
		for(int i = 0; i < repeat; i++) {
			rst = "";
			testcase = br.readLine().split(" ");
			text = testcase[1].split("");
			for(int j = 0; j < text.length; j++) {
				rst = "";
				for(int k = 0; k < Integer.parseInt(testcase[0]); k++) {
					rst += text[j];
				}
				bw.write(rst);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}