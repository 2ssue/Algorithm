import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int exec_num = Integer.parseInt(br.readLine());
		int sum;
		String[] num = new String[2];
		
		for(int i = 0; i < exec_num; i++) {
			num = br.readLine().split(" ");
			bw.write(Integer.parseInt(num[0]) + Integer.parseInt(num[1])+"\n");
		}
		bw.flush();
		bw.close();
	}
}