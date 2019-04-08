import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tcase = br.readLine().split(" ");
		String[] num = br.readLine().split(" ");
		
		for(int i = 0; i < Integer.parseInt(tcase[0]); i++) {
			if (Integer.parseInt(num[i]) < Integer.parseInt(tcase[1]))
				bw.write(num[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}