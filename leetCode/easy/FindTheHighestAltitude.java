package src.src.leetCode.easy;

public class FindTheHighestAltitude {
    /*
    * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
    * The biker starts his trip on point 0 with altitude equal 0.
    You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i and i + 1
    * for all (0 <= i < n). Return the highest altitude of a point.
    */

    public static int largestAltitude(int[] gain) {

        int currentHeight = 0;
        int maxHeight = 0;

        for (int j : gain) {
            currentHeight += j;
            maxHeight = Math.max(currentHeight, maxHeight);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        // expected output = 1
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
    }


}
