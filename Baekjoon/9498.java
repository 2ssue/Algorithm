import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int score = Integer.parseInt(br.readLine());
		
		String[] grade = {"A", "B", "C", "D", "F"};
		 
		score = score/10;
		
		if (score >= 9) bw.write(grade[0]);
		else if (score >= 8) bw.write(grade[1]);
		else if (score >= 7) bw.write(grade[2]);
		else if (score >= 6) bw.write(grade[3]);
		else bw.write(grade[4]);
		
		bw.flush();
		bw.close();
	}
}