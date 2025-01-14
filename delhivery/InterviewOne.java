package src.src.delhivery;

public class InterviewOne {
//    /*
//    Given a sorted and rotated array arr[] of n distinct elements, the task is to find the index of the given key in the array.
//    If the key is not present in the array, return -1
//      Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 2
//      Output: 8*/


    public static int solution(int [] array, int target) {

        if (array == null || array.length==1&&array[0] != target) {
            return -1;
        }


        // begin bin search
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int leftElement = array[left]; // 1
            int rightElement = array[right]; // 3
            int middle = ((left + right ) / 2) + 1; // 4
            int middleElement = array[middle]; // 2

            if (leftElement == target) {            // [],
                return left;
            }else if(rightElement == target) {
                return right;
            }else if (middleElement == target){
                return middle;
            }

            if( middleElement > target){
                left = middle;
            }else if (middleElement < target ){
                right = middle;
            }

        }

        return -1;
    }


    // Sort an array of 0s, 1s and 2s? Input: [1,2,0,2,1,0,2] -> Output: [0,0,1,1,2,2,2]
    // [0,2,0,2,1,1,2] >> ++++ [2,2,0,2,1,1,1] > [1,2,0,2,1,1,2] > []
    // [0,1,0,2,1,2,2]
    // l = 1, m = 2, r = 2 >> l = 1, m = 2, r = 0 >> l = 0, m = 1, r =2 >> l = 2, m = 1, r = 1 >> l = 1, m = 1, r = 2 >> l = 1, m = 0, r =2
    // [1,2,0,2,1,0,2]  >> [0,2,0,1,1,2,2] >> [0,1,0,1,2,2,2] >> [0,0,1,1,2,2,2]

    public static int[] solution2(int[] input){

        int left = 0;
        int right = input.length - 1;
        int mid = (left + right)/2 + 1;

        while (left < right) {
            if (input[left] > input[mid]){
                swap(left, mid, input);
            }
            if (input[right] < input[mid]){
                swap(right, mid, input);
            }

        }

        return input;
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) {
        int [] array = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target = 10;
        int result = solution(array, target);
        int[] srr = new int[]{0,2,0,2,1,1,2};
        solution2(srr);
        System.out.println(srr);
    }

}
