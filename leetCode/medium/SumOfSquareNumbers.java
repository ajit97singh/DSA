package src.src.leetCode.medium;

public class SumOfSquareNumbers {

    /*
    Given a non-negative integer c, decide whether there are two integers a and b such that a2 + b2 = c.
    */

    public static boolean judgeSquareSum(int c) {
        // Using binary search we need to see if there is point (mid) between 0 and sqrt(c),
        // such that mid x mid = c - a2

        for(int a = 0; a*a <= c; a++){
            int target = c - (int) a*a;
            if(binarySearch(0, target, target)){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(long left, long target,int right){

        if (left > target)
            return false;
        long mid = left + (target - left) / 2;
        if (mid * mid == right)
            return true;
        if (mid * mid > right){
            return binarySearch(left, mid - 1, right);
        }else {
            return binarySearch(mid + 1, target, right);
        }

    }

    public static void main(String[] args) {
        int input = 10;
        boolean output = judgeSquareSum(input);
        System.out.println(output);
    }
}
