package src.src.algoexpert.hard;

import java.util.*;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        // Write your code here.
        Arrays.sort(array);

        int maxLength = 1;
        int rangeStart = array[0];
        int rangeEnd = array[0];

        int currentLength = 1;
        int currentStart = array[0];
        int currentEnd = array[0];

        for(int i = 1; i < array.length; i++) {

            if (array[i] - array[i-1] == 1) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    rangeStart = currentStart;
                    rangeEnd = array[i-1];
                    currentStart = array[i];
                    currentLength = 1;
                }
            }

        }
        if (currentLength > maxLength) {
            rangeStart = currentStart;
            rangeEnd = array[array.length-1];
        }
        return new int[] {rangeStart, rangeEnd};
    }

    public static void main(String [] args) {
        int[] input = {8, 4, 2, 10, 3, 6, 7, 9, 1};
        int[] output = largestRange(input.clone());
        System.out.println(Arrays.toString(output));

        
    }
}
