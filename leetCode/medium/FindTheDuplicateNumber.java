package src.src.leetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Map<Integer,Object> map = new HashMap<>();
        for(int element: nums){
            if(Objects.isNull(map.get(element))){
                map.put(element,0);
            }else {
                return element;
            }
        }
        return 0;
    }

    // TODO: Use Floyd's cycle detection algorithm to get constant space complexity

    public int findDuplicate2(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for(int element: nums){
            if(seen.contains(element)){
                seen.add(element);
            }else {
                return element;
            }
        }
        return 0;
    }
}
