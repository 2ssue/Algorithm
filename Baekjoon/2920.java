import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] scales = br.readLine().split(" ");
		
		String[] ascend = {"1", "2", "3", "4", "5", "6", "7", "8"};
		String[] decend = {"8", "7", "6", "5", "4", "3", "2", "1"};
		
		if (Arrays.equals(scales, ascend)) bw.write("ascending");
		else if (Arrays.equals(scales, decend)) bw.write("descending");
		else bw.write("mixed");
		
		bw.flush();
		bw.close();
	}
}