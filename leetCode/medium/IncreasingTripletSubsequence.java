package src.src.leetCode.medium;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for(int n : nums){
            if(n <= small){
                small = n;
            }else if( n <= big){
                big = n;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }

}
