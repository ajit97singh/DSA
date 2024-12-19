package src.src.leetCode.medium;

import java.util.*;

public class ContinuousSubarrays {

    static long solution(int[] nums) {
        long count = 0;
        int left = 0;
        int right = 0;
        int min = nums[0];
        int max = nums[0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Integer::compare);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b,a));

        while (right < nums.length) {
            int element = nums[right];
            minHeap.add(element);
            maxHeap.add(element);
            max = maxHeap.peek();
            min = minHeap.peek();

            if (max - min <= 2) {
                count += (right - left + 1);
                right++;
            }else {
                // start moving left until max min condition is satisfied
                while (max - min > 2) {
                    if (left == nums.length) {
                        break;
                    }
                    int leftElement = nums[left];
                    if (!maxHeap.isEmpty() && leftElement == maxHeap.peek()){
                        maxHeap.poll();
                        max = maxHeap.peek();
                    } else if (!minHeap.isEmpty() && leftElement == minHeap.peek()){
                        minHeap.poll();
                        min = minHeap.peek();
                    }
                    left++;
                }
                count += (right - left + 1);
                right++;
            }
        }


        return count;
    }

    public static void main(String [] args) {
        int[] input = {42,41,42,41,41,40,39,38};
        long out = solution(input);
        out = 0;
    }

}
