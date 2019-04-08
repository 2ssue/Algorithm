import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] score = br.readLine().split(" ");
		double[] nScore = Arrays.stream(score).mapToDouble(Double::parseDouble).toArray();
		
		Arrays.sort(nScore);
		
		for (int i = 0; i < num; i++) {
			nScore[i] = nScore[i]/nScore[num - 1] * 100;
		}
		
		double rst = 0;
		
		for (int i = 0; i < num; i++) {
			rst += nScore[i];
		}
		
		rst = rst/num;
		
		System.out.println(rst);
	}
}