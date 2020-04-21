import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int topNumber = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> topHeights = new Stack<>();
        Stack<Integer> topIndexes = new Stack<>();

        topHeights.push(Integer.parseInt(st.nextToken()));
        topIndexes.push(1);
        bw.write("0 ");

        for (int i = 1; i < topNumber; i++) {
            int currentTopHeight = Integer.parseInt(st.nextToken());

            while (!topHeights.isEmpty()) {
                int previousTopHeight = topHeights.peek();

                if (previousTopHeight > currentTopHeight) {
                    bw.write(topIndexes.peek() + " ");
                    break;
                }

                topHeights.pop();
                topIndexes.pop();
            }

            if (topHeights.isEmpty()) {
                bw.write("0 ");
            }

            topHeights.push(currentTopHeight);
            topIndexes.push(i + 1);
        }

        bw.flush();
        bw.close();
    }
}