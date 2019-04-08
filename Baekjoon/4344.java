import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		double avg = 0;
		double rst;
		
		for (int i = 0; i < num; i++) {
			rst = 0;
			avg = 0;
			String[] score = br.readLine().split(" ");
			for (int j = 1; j <= Integer.parseInt(score[0]); j++) {
				avg += Integer.parseInt(score[j]);
			}
			avg = avg/Integer.parseInt(score[0]);
			
			for (int k = 1; k <= Integer.parseInt(score[0]); k++) {
				if (Integer.parseInt(score[k])>avg) rst += 1;
			}
			
			rst /= Integer.parseInt(score[0]);
			rst *= 100;
			
			bw.write(String.format("%.3f", rst)+"%\n");
		}
		bw.flush();
		bw.close();
	}
}