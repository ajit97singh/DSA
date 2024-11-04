package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElements2 {
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey((Integer) num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>nums.length/3.0){
                result.add(entry.getKey());
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
}
