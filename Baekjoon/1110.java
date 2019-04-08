import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int tmp, sum = 0, cycle = 0;
	
		tmp = num;
		while(true) {
			sum = tmp/10 + tmp%10;
			tmp = tmp%10*10 + sum%10;
			cycle++;
			if (tmp == num) break;
		}
		
		bw.write(Integer.toString(cycle));
		bw.flush();
		bw.close();
	}
}