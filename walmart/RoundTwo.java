package src.src.walmart;

import java.util.*;

public class RoundTwo {

    private static int max = Integer.MIN_VALUE;

    public static List<Integer> permute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<Integer> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            int tempMax = max;
            for(int i = 1; i <= tempList.size(); i++) {

            }
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) {
                    continue;
                }
                tempList.add(num);
                backtrack(result, tempList, nums);
                tempList.removeLast();
            }
        }
    }



    private static int solve(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for(int num: arr) {
            if (num > highest) {
                highest = num;
            }else if (num < lowest){
                lowest = num;
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(int key: freq.keySet()){
            if (key == highest && freq.get(key) > 2){
                freq.put(key, 2);
            }else if (key == lowest && freq.get(key)> 2){
                freq.put(key, 2);
            }else if (freq.get(key)>3){
                freq.put(key, 3);
            }
        }
        int res = 0;
        for(int val: freq.values()){
            res += val;
        }

        // 2 high and two  lowest --> max freq two
        // max freq of any element is 3
        return res;
    }

    // [1,2,3,4,5,6,7,7,7,7,7,7,7] --> 1,2,7,4,3 5,6,7


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 5};
        int[] arr = {1,2,3,4,5,6,7,7,7,7,7,7,7};
        int result = solve(arr);
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Maximum length: " + result);
        System.out.println("\nPossible arrangement that achieves maximum length:");
        System.out.println("[1,3,5,4,2,5]");
        System.out.println("First increasing: 1->3->5");
        System.out.println("Then decreasing: 5->4->2");
        System.out.println("Finally increasing: 2->5");
    }
}
