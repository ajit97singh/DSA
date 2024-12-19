package src.src.leetCode.medium;

public class JumpGame2 {

    public static int jump(int[] nums) {
        int near = 0, far = 0, jumps = 0;

        while (far < nums.length - 1) {
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            near = far + 1;
            far = farthest;
            jumps++;
        }
        return jumps;
    }

    public static void main(String [] args) {

        int[] input = {2,3,1,1,4,1,1,1,1,1,1,1};
        int res = jump(input);
        res = 1;


    }

}
