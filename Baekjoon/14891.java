import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Wheel[] wheels = new Wheel[4];

        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(br.readLine());
        }

        int cycleCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < cycleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNumber = Integer.parseInt(st.nextToken()) - 1;
            int rotateDirection = Integer.parseInt(st.nextToken());

            rotateWheels(wheels, wheelNumber, rotateDirection);
        }

        int score = getWheelScore(wheels);

        bw.write(Integer.toString(score));

        bw.flush();
        bw.close();
    }

    public static void rotateWheels(Wheel[] wheels, int wheelNumber, int direction) {
        int[] directions = new int[4];
        directions[wheelNumber] = direction;

        for (int i = wheelNumber; i < 4; i++) {
            if (checkRightSideWheelCanRotate(wheels, i)) {
                directions[i + 1] = directions[i] * -1;
            } else {
                break;
            }
        }

        for (int i = wheelNumber; i > 0; i--) {
            if (checkLeftSideWheelCanRotate(wheels, i)) {
                directions[i - 1] = directions[i] * -1;
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            wheels[i].rotate(directions[i]);
        }
    }

    public static boolean checkRightSideWheelCanRotate(Wheel[] wheels, int wheelNumber) {
        if (wheelNumber == 3) {
            return false;
        }

        return wheels[wheelNumber].getRightSidePole() != wheels[wheelNumber + 1].getLeftSidePole();
    }

    public static boolean checkLeftSideWheelCanRotate(Wheel[] wheels, int wheelNumber) {
        if (wheelNumber == 0) {
            return false;
        }

        return wheels[wheelNumber].getLeftSidePole() != wheels[wheelNumber - 1].getRightSidePole();
    }

    public static int getWheelScore(Wheel[] wheels) {
        int score = 0;

        for (int i = 0; i < 4; i++) {
            if (wheels[i].getFirstPole() == 1) {
                score += Math.pow(2, i);
            }
        }

        return score;
    }
}

class Wheel {
    private Deque<Integer> poles;

    public Wheel(String wheelInformation) {
        poles = new ArrayDeque<>();

        for (String pole : wheelInformation.split("")) {
            poles.offer(Integer.parseInt(pole));
        }
    }

    public int getFirstPole() {
        return poles.peekFirst();
    }

    public int getRightSidePole() {
        int firstPole = poles.pollFirst();
        int secondPole = poles.pollFirst();
        int rightSidePole = poles.peekFirst();

        poles.push(secondPole);
        poles.push(firstPole);

        return rightSidePole;
    }

    public int getLeftSidePole() {
        int lastPole = poles.pollLast();
        int leftSidePole = poles.peekLast();

        poles.offer(lastPole);

        return leftSidePole;
    }

    public void rotate(int direction) {
        switch (direction) {
            case 1:
                rotateClockwise();
                break;
            case -1:
                rotateCounterclockwise();
                break;
        }
    }

    private void rotateClockwise() {
        this.poles.push(this.poles.pollLast());
    }

    private void rotateCounterclockwise() {
        this.poles.offer(this.poles.pollFirst());
    }
}