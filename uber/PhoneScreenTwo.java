package src.src.uber;


// Given an array of integers, and an integer N, find the length of the longest “N-stable” continuous subarray.
// An array is defined to be “N-stable” when the pair-wise difference between any two elements in the array is smaller or equal to N.
// A subarray of a 0-indexed integer array is a contiguous non-empty sequence of elements within an array.
// For instance, for array [ 4, 2, 3, 6, 2, 2, 3, 2, 7 ], and N = 1
// The return value should be 4, since the longest 1-stable subarray is [ 2, 2, 3, 2 ].


// For [8,2,4, 1,7] and N =  4. Should return 2 because longest N-stable subarray is [2,4](or [4,7])

// Main class should be named 'Solution' and should not be public.
// [8,2,4,1,7] -->
// 1,2,4,-4 ..... N <= 3
//
// {
//        1: 0    , 2:1, 4:2, 8:3
// }

// need to find a DS to get min max of moving window  , hashmap not working
//


import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

//left , right pointer
// minq -> 1,2,4
// maxq -> 4,2,1 --> O(nlog(n))
// min = 1,
// max = 4,
public class PhoneScreenTwo {

    public int sol(int[] arr, int k) {
        int maxLen = 1;
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>();


        int left = 0;
        int right = 1;
        minq.add(arr[0]);
        maxq.add(arr[0]);

        int min = arr[0];
        int max = arr[0];

        while (right < arr.length) {
            // move right
            int element = arr[right];
            if (element < min) {
                min = element;
            }else if (element > max) {
                max = element;
            }
            // check rule
            if( (max - min) > k) {
                while (left < right) {
                    int leftElement = arr[left];
                    if (left == min) {
                        minq.poll();
                        maxq.remove(leftElement);
                        min = minq.peek();
                    }else if (left == max){
                        maxq.poll();
                        max = maxq.peek();
                        minq.remove(leftElement);
                    }else {
                        maxq.remove(leftElement);
                        minq.remove(leftElement);
                    }
                    // move left
                    left++;
                }
            } else {
                right++;
                maxLen = Math.max(maxLen, right - left + 1);
            }// condition breaks

        }


        return maxLen;
    }



}
