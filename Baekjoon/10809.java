import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", 
				"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		int[] pos = new int[26];
		String input = br.readLine();
		
		for (int i = 0; i < 26; i++) {
			pos[i] = input.indexOf(alphabet[i]);
			bw.write(Integer.toString(pos[i]) + " ");
		}
		
		bw.flush();
		bw.close();
	}
}