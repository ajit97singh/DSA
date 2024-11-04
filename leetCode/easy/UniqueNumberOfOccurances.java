package src.src.leetCode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class UniqueNumberOfOccurances {
    /*
    Given an array of integers arr, return true if the number of occurrences of each value in the array
    is unique or false otherwise.
    */

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> readElements = new HashMap<>();

        for(int x: arr){
            if(Objects.nonNull(readElements.get(x))){
                readElements.put(x, readElements.get(x) + 1);
            }else {
                readElements.put(x, 1);
            }
        }

        HashSet<Integer> occurrences = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry: readElements.entrySet()){
            if(!occurrences.add(entry.getValue())){
                return false;
            }
        }
        return true;
    }
}
