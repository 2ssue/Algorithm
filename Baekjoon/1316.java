import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		String input;
		String arrInput[];
		ArrayList<String> arr = new ArrayList<String>();
		int check, result = 0;
		
		for(int i = 0; i < num; i++) {
			arr.removeAll(arr);
			check = 0;
			input = br.readLine();
			arrInput = input.split("");
			arr.add(arrInput[0]);
			for(int j = 1; j < arrInput.length; j++) {
				for(int k = 0; k < arr.size(); k++) {
					if (arrInput[j].equals(arr.get(k))) {
						if (arrInput[j].equals(arrInput[j-1]))
							continue;
						else 
							check++;
					}
				}
				if (check == 0) arr.add(arrInput[j]);
			}
			if (check == 0) result++;
		}
		
		bw.write(Integer.toString(result));
	 	
		bw.flush();
		bw.close();
	}
}