package src.src.leetCode.easy;

public class ThreeConsecutiveOdds {
    /*
    Given an integer array arr,
    return true if there are three consecutive odd numbers in the array.
    Otherwise, return false.
    */

    public static boolean threeConsecutiveOdds(int[] arr) {
        int cosecOddSize = 0;
        for (int element: arr) {
            if (element % 2 != 0) {
                cosecOddSize++;
            }else {
                cosecOddSize = 0;
            }
            if (cosecOddSize == 3){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int [] input = new int[]{1,2,34,3,4,5,7,23,1};
        boolean output = threeConsecutiveOdds(input);
        System.out.println(output);
    }
}
