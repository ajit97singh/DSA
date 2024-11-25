package src.src.leetCode.easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
//    Given an integer array nums sorted in non-decreasing order,
//    return an array of the squares of each number sorted in non-decreasing order.


    public static int[] sortedSquares(int[] array) {

        int negativePointer = 0;
        int positivePointer = 0;

        // find point of inflexion and negative - positive pointers
        if (array[0] >= 0) {
            negativePointer = -1;
        } else if (array[array.length - 1] < 0) {
            negativePointer = array.length - 1;
            positivePointer = array.length;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= 0) {
                    negativePointer = i - 1;
                    positivePointer = i;
                    break;
                }
            }
        }

        // a while to consume pointers
        int resultArrayIndex = 0;
        int[] result = new int[array.length];

        while (resultArrayIndex < array.length) {
            int negativeSquare = Integer.MAX_VALUE;
            int positiveSquare = Integer.MAX_VALUE;

            if (negativePointer >= 0) {
                negativeSquare = array[negativePointer] * array[negativePointer];
            }
            if (positivePointer < array.length) {
                positiveSquare = array[positivePointer] * array[positivePointer];
            }
            if (negativeSquare < positiveSquare) {
                result[resultArrayIndex] = negativeSquare;
                negativePointer--;
            } else {
                result[resultArrayIndex] = positiveSquare;
                positivePointer++;
            }
            resultArrayIndex++;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-10, -5, 0, 5, 10};
        int[] output = sortedSquares(input);
        System.out.println(Arrays.toString(output));
    }
}
