import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int row = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());

        int[][] table = new int[row][row];
        int value = row * row;
        int x = 0;
        int y = 0;
        int d = 0;

        while (value > 0) {
            table[x][y] = value;

            if (x + direction[d][0] < 0) {
                d = changeDirection(d);
            } else if (x + direction[d][0] >= row) {
                d = changeDirection(d);
            } else if (y + direction[d][1] < 0) {
                d = changeDirection(d);
            } else if (y + direction[d][1] >= row) {
                d = changeDirection(d);
            } else if (table[x + direction[d][0]][y + direction[d][1]] != 0) {
                d = changeDirection(d);
            }

            x += direction[d][0];
            y += direction[d][1];

            value--;
        }

        int numberX = 0;
        int numberY = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                bw.write(Integer.toString(table[j][i]) + " ");
                if (table[i][j] == number) {
                    numberX = i + 1;
                    numberY = j + 1;
                }
            }
            bw.write("\n");
        }

        bw.write(Integer.toString(numberY) + " " + Integer.toString(numberX));

        bw.flush();
        bw.close();
    }

    public static int changeDirection(int direction) {
        return (direction + 1) % 4;
    }
}