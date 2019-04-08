import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		input = input.trim();
		String [] arr;
		
		if (input.length() != 0) {
			arr = input.split(" ");
			bw.write(Integer.toString(arr.length));
		}else bw.write("0");
		
		bw.flush();
		bw.close();
	}
}