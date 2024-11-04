package src.src.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int highestNumberOfCurrentCandies = 0;
        for(int candyCount: candies){
            highestNumberOfCurrentCandies = Math.max(highestNumberOfCurrentCandies, candyCount);
        }
        List<Boolean> result = new ArrayList<>();
        for(int candyCount: candies){
            if((candyCount + extraCandies)>=highestNumberOfCurrentCandies){
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }
}
