package src.src.crackingTheCodingInterview.bitManipulation;

import java.util.*;

public class FlipBitToWin {

    int solution(int i) {
        String binaryString = Integer.toBinaryString(i);
        List<Integer[]> subSquqnceLengths = new ArrayList<>();
        char[] arr = binaryString.toCharArray();
        int leftPointer = 0;

        // initialize leftpointer to fiest subsequence start
        leftPointer = initializePointer(arr, leftPointer);

        int rightPointer = leftPointer;
        while (rightPointer < arr.length) {
            if (arr[rightPointer] == '0') {
                // sequence break
                subSquqnceLengths.add(new Integer[]{leftPointer, rightPointer - 1});
                leftPointer = initializePointer(arr, rightPointer);
                rightPointer = leftPointer;
            } else {
                rightPointer++;
            }
        }
        if (arr[rightPointer - 1] == '1') {
            subSquqnceLengths.add(new Integer[]{leftPointer, rightPointer - 1});
        }
        int i1 = rightPointer <<= 5;

        return getResult(subSquqnceLengths);
    }

    private static int getResult(List<Integer[]> subSquqnceLengths) {
        int result = 0;

        for (int index = 0; index < subSquqnceLengths.size() - 1; index ++) {
            //left pair
            int leftStart = subSquqnceLengths.get(index)[0];
            int leftEnd = subSquqnceLengths.get(index)[1];
            //right pair
            int rightStart = subSquqnceLengths.get(index+1)[0];
            int rightEnd = subSquqnceLengths.get(index+1)[1];

            if ((rightStart - leftEnd) == 2) {
                result = Math.max(result, (rightEnd - leftStart) + 1);
            }

        }
        return result;
    }

    int initializePointer(char[] array, int pointer) {

        while (pointer < array.length) {
            if (array[pointer] == '1') {
                break;
            }else {
                pointer++;
            }
        }
        return pointer;
    }

    public static void main(String [] args) {

        int res = new FlipBitToWin().solution(1775);
        System.out.println(res);


    }
}
