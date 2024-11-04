package src.src.ztmCourse;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static int[] solution(int [] input){
        int length = input.length;
        if(length <= 1){
            return input;
        }
        for(int i = 1; i< length - 1; i++){
            int current = input[i];
            int prevElementIndex = i - 1;
            int prev = input[prevElementIndex];
            boolean startMoving = false;
            int temp=input[i];
            if(current <= prev){
                for(int j = 0; j <= i; j++){
                    if(!startMoving && current<input[j]){
                        startMoving = true;
                        temp = input[j];
                        input[j] = current;
                        continue;
                    }
                    if(startMoving){
                        int temp2 = input[j];
                        input[j] = temp;
                        temp = temp2;
                    }
                }
            }
        }
        return input;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{-6, 1, 2, -1, 10})));
    }
}
