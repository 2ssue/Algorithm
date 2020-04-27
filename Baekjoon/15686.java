import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityWidth = Integer.parseInt(st.nextToken());
        int maxChickenHouse = Integer.parseInt(st.nextToken());

        ChickenCity chickenCity = new ChickenCity(cityWidth, maxChickenHouse);

        for (int i = 0; i < cityWidth; i++) {
            chickenCity.enrollCityInformation(br.readLine(), i);
        }

        int minChickenLength = chickenCity.getMinistChickenLength();

        bw.write(Integer.toString(minChickenLength));

        bw.flush();
        bw.close();
    }
}

class ChickenCity {
    private final static int HOUSE = 1;
    private final static int CHICKEN_HOUSE = 2;

    private List<int[]> houseLocation = new ArrayList<>();
    private List<int[]> chickenHouseLocation = new ArrayList<>();
    private boolean[] selectedChickenHouse = new boolean[13];
    private int cityWidth = 0;
    private int maxChickenHouseCount = 0;
    private int cityChickenLength = 9999999;

    public ChickenCity(int cityWidth, int maxChickenHouseCount) {
        this.cityWidth = cityWidth;
        this.maxChickenHouseCount = maxChickenHouseCount;

    }

    public void enrollCityInformation(String cityInformation, int row) {
        StringTokenizer st = new StringTokenizer(cityInformation);

        for (int i = 0; i < this.cityWidth; i++) {
            int info = Integer.parseInt(st.nextToken());

            switch (info) {
                case 0:
                    continue;
                case HOUSE:
                    this.houseLocation.add(new int[] { row + 1, i + 1 });
                    continue;
                case CHICKEN_HOUSE:
                    this.chickenHouseLocation.add(new int[] { row + 1, i + 1 });
                    continue;
            }
        }
    }

    private int distance(int[] house, int[] chickenHouse) {
        return Math.abs(house[0] - chickenHouse[0]) + Math.abs(house[1] - chickenHouse[1]);
    }

    private void cleanUpChickenHouse(int selectedIndex, int selectedCount) {
        int chickenHouseCount = chickenHouseLocation.size();

        if (selectedCount == this.maxChickenHouseCount) {
            int chickenLength = 0;
            int houseCount = houseLocation.size();

            for (int i = 0; i < houseCount; i++) {
                int minLength = this.cityWidth * 2;

                for (int j = 0; j < chickenHouseCount; j++) {
                    if (selectedChickenHouse[j]) {
                        int gap = this.distance(houseLocation.get(i), chickenHouseLocation.get(j));
                        minLength = Math.min(gap, minLength);
                    }
                }

                chickenLength += minLength;
            }

            this.cityChickenLength = Math.min(chickenLength, this.cityChickenLength);
            return;
        }

        if (selectedIndex == chickenHouseCount) {
            return;
        }

        this.selectedChickenHouse[selectedIndex] = true;
        cleanUpChickenHouse(selectedIndex + 1, selectedCount + 1);

        this.selectedChickenHouse[selectedIndex] = false;
        cleanUpChickenHouse(selectedIndex + 1, selectedCount);
    }

    public int getMinistChickenLength() {
        cleanUpChickenHouse(0, 0);

        return this.cityChickenLength;
    }
}