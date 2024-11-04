package src.src.ztmCourse;


import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static int[] merge(int [] left, int [] right){
        int lLength = left.length;
        int rLength = right.length;
        int [] result = new int[lLength + rLength];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while(leftIndex < lLength || rightIndex < rLength){
            if(leftIndex == lLength){
                result[resultIndex] = right[rightIndex];
                resultIndex++;
                rightIndex++;
            }else if (rightIndex == rLength){
                result[resultIndex] = left[leftIndex];
                leftIndex++;
                resultIndex++;
            }else if(left[leftIndex] < right[rightIndex]){
                result[resultIndex] = left[leftIndex];
                resultIndex++;
                leftIndex++;
            }else {
                result[resultIndex] = right[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }
        return result;
    }
    public static int [] mergeSort(int [] input){
        int length = input.length;
        if(length <= 1){
            return input;
        }
        int [] left = Arrays.stream(input, 0, length / 2 ).toArray();
        int [] right = Arrays.stream(input, length / 2 , length).toArray();
        int[] result = merge(
                mergeSort(left),
                mergeSort(right)
        );
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{1,0,3})));
    }

}
