package src.src.algoexpert.easy;

import java.util.List;
import java.util.Objects;

public class ValidateSubsequence {
//    Given two non-empty array of integers , write a function that determines if the second array is a subsequence
//    of first array.
//    A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but they are in the
//    same order.

    public static boolean isValidSubsequence(
            List<Integer> array, List<Integer> sequence
    ) {

        int sequenceIndex = 0;
        int sequenceSize = sequence.size();

        for (Integer integer : array) {
            if (sequenceIndex < sequenceSize && (Objects.equals(integer, sequence.get(sequenceIndex)))) {
                sequenceIndex++;
            }
        }


        return sequenceIndex == sequenceSize;
    }
}
