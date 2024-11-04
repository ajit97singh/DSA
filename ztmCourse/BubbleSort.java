package src.src.ztmCourse;

import java.util.Arrays;

public class BubbleSort {
    public static int[] solution(int [] input){
        if(input.length<=1){
            return input;
        }
        int i = input.length - 2;
        while (i>=0){
            for(int j = 0; j<=i; j++){
                int current = input[j];
                int next = input[j+1];
                if(current > next){
                    input[j] = next;
                    input[j+1] = current;
                }
            }
            i--;
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 3, 0, -122})));
    }
}
