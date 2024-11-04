package src.src.leetCode.easy;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length];
        int nonTargetCount = 0;
        for (int num : nums) {
            if (num != val) {
                nums[nonTargetCount] = num;
                nonTargetCount++;
            }
        }
        return nonTargetCount;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
    }
}
