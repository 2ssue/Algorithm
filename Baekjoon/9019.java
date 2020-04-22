import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] inputs = br.readLine().split(" ");
            int before = Integer.parseInt(inputs[0]);
            int after = Integer.parseInt(inputs[1]);

            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(before);
            visited[before] = true;
            command[before] = "";

            while (!queue.isEmpty()) {
                int currentValue = queue.poll();

                if (visited[after]) {
                    bw.write(command[after] + "\n");
                    break;
                }

                int d = (currentValue * 2) % 10000;
                int s = currentValue == 0 ? 9999 : currentValue - 1;
                int l = (currentValue % 1000) * 10 + (currentValue / 1000);
                int r = (currentValue % 10) * 1000 + currentValue / 10;

                if (!visited[d]) {
                    queue.add(d);
                    visited[d] = true;
                    command[d] = command[currentValue] + "D";
                }

                if (!visited[s]) {
                    queue.add(s);
                    visited[s] = true;
                    command[s] = command[currentValue] + "S";
                }

                if (!visited[l]) {
                    queue.add(l);
                    visited[l] = true;
                    command[l] = command[currentValue] + "L";
                }

                if (!visited[r]) {
                    queue.add(r);
                    visited[r] = true;
                    command[r] = command[currentValue] + "R";
                }
            }
        }

        bw.flush();
        bw.close();
    }
}