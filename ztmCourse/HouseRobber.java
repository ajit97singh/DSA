package src.src.ztmCourse;

public class HouseRobber {
    public static int rob(int[] nums) {
        int rob = 0;
        int norob = 0;
        for (int num : nums) {
            int newRob = norob + num;
            int newNoRob = Math.max(norob, rob);
            rob = newRob;
            norob = newNoRob;
        }
        return Math.max(rob, norob);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{5, 0, 0, 500, 5}));
    }

}
