import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        Queue<Integer> dateList = new LinkedList<>();
        PriorityQueue<Integer> possibleSupplyList = new PriorityQueue<>(Collections.reverseOrder());

        int currentFlour = stock;
        int supplyCount = 0;

        for (int date : dates) {
            dateList.offer(date);
        }

        for (int date = 0; date < k; date++) {
            if (!dateList.isEmpty() && dateList.peek() == date) {
                possibleSupplyList.offer(supplies[dates.length - dateList.size()]);
                dateList.poll();
            }

            if (currentFlour == 0) {
                currentFlour += possibleSupplyList.poll();
                supplyCount += 1;
            }

            currentFlour -= 1;
        }

        return supplyCount;
    }
}