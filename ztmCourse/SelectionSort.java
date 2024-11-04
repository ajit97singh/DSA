package src.src.ztmCourse;

import java.util.Arrays;

public class SelectionSort {
    public static int [] solution(int [] input){
        int length = input.length;
        if (length <= 1){
            return input;
        }
        for (int i = 0; i < length - 1; i++){
            int current = input[i];
            int smallest = input[i];
            int smallestIndex = i;
            for (int j = i; j<length; j++){
                current = input[j];
                if(current < smallest){
                    smallest = current;
                    smallestIndex = j;
                }
            }
            int elementToSwap = input[i];
            input[i] = smallest;
            input[smallestIndex] = elementToSwap;
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 20, 3, -1, 0, 0, 0})));
    }
}
