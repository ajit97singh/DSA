package src.src.elementsOfProgrammingInterviews;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxProfitFromDateRange {

    public static int [] solution(int[] days, int maxProfit) {

        return new int[]{days.length, Arrays.stream(days).sum()};
    }

    public int bestProfit(int profit1, int profit2, ArrayList<Integer> days1, ArrayList<Integer>  days2){
//        int combinedProfit = days2.stream().max(Integer::intValue)
        return 0;
    }

    public static void main(String[] args) {
        int maxProfit = 0;
        int [] days = new int[] {1,2,3,4,5,6,7,8};
        solution(days, maxProfit);
        System.out.println(maxProfit);
    }
}
