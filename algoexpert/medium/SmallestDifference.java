package src.src.algoexpert.medium;

import java.util.*;

public class SmallestDifference {


    int[] solution(int[] arrayOne, int[] arrayTwo) {

        int arrOnePointer = 0;
        int arrTwoPointer = 0;

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int diff = Integer.MAX_VALUE;
        int[] result = new int[2];


        while (arrOnePointer < arrayOne.length && arrTwoPointer < arrayTwo.length) {
            int arrOneElement = arrayOne[arrOnePointer];
            int arrTwoElement = arrayTwo[arrTwoPointer];
            int currentDiff = Math.abs(arrOneElement - arrTwoElement);

            if (currentDiff < diff) {
                diff = currentDiff;
                result[0] = arrOneElement;
                result[1] = arrTwoElement;
            }
            if (arrOneElement < arrTwoElement && arrOnePointer < arrayOne.length-1) {
                arrOnePointer++;
            }else if (arrTwoPointer < arrayTwo.length-1){
                arrTwoPointer++;
            }else {
                break;
            }
        }
        return result;
    }

    public static void main(String [] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        int[]res = new SmallestDifference().solution(arrayOne, arrayTwo);
        System.out.println(res);
    }
}
