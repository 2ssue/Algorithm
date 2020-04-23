import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int dayMoving = Integer.parseInt(st.nextToken());
        int nightMoving = Integer.parseInt(st.nextToken());
        int treeHeight = Integer.parseInt(st.nextToken());

        int day = (treeHeight - nightMoving) % (dayMoving - nightMoving) == 0
                ? (treeHeight - nightMoving) / (dayMoving - nightMoving)
                : (treeHeight - nightMoving) / (dayMoving - nightMoving) + 1;

        bw.write(Integer.toString(day));

        bw.flush();
        bw.close();
    }
}