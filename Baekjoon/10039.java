import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] score = new int[5];
		int input_score = 0;
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			input_score = Integer.parseInt(br.readLine());
			if (input_score < 40) input_score = 40;
			score[i] = input_score;
			sum += score[i];
		}
		sum /= 5;
		
		bw.write(Integer.toString(sum));
		
		bw.flush();
		bw.close();
	}
}