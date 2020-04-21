import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int truckNumber = Integer.parseInt(st.nextToken());
        int bridgeLength = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] truckWeights = new int[truckNumber];

        for (int i = 0; i < truckNumber; i++) {
            truckWeights[i] = Integer.parseInt(st.nextToken());
        }

        int result = moveTrucks(bridgeLength, weight, truckWeights, truckNumber);
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    private static int moveTrucks(int bridgeLength, int weight, int[] truckWeights, int truckNumber) {
        int time = 0;
        Queue<Truck> bridge = new LinkedList<>();
        int lastEnterTruckIndex = 0;
        int currentBridgeWeight = 0;

        while (lastEnterTruckIndex < truckNumber) {
            time++;

            if (!bridge.isEmpty()) {
                Truck frontTruck = bridge.peek();
                if (time - frontTruck.enterTime == bridgeLength) {
                    currentBridgeWeight -= bridge.poll().weight;
                }
            }

            int compareTruck = truckWeights[lastEnterTruckIndex];
            if (currentBridgeWeight + compareTruck <= weight) {
                bridge.offer(new Truck(compareTruck, time));
                lastEnterTruckIndex++;
                currentBridgeWeight += compareTruck;
            }
        }

        time += bridgeLength;

        return time;
    }
}

class Truck {
    public int weight;
    public int enterTime;

    public Truck(int weight, int enterTime) {
        this.weight = weight;
        this.enterTime = enterTime;
    }
}