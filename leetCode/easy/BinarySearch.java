package src.src.leetCode.easy;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }else if(target == nums[0]){
            return 0;
        }else if(target > nums[nums.length -1 ]){
            return -1;
        } else if (target<nums[0]) {
            return -1;
        }

        int lowIndex = 0;
        int highIndex = nums.length - 1;
        int midIndex = 0;
        int midValue;
        int lowValue;
        int highValue;
        while(lowIndex!=highIndex){
            midIndex = (lowIndex + highIndex) / 2;
            midValue = nums[midIndex];
            lowValue = nums[lowIndex];
            highValue = nums[highIndex];
            if(target == lowValue){
                return lowIndex;
            }else if (target == highValue){
                return highIndex;
            }else if(target == midValue){
                return midIndex;
            }else if(target > midValue){
                lowIndex = midIndex + 1;
            }else {
                highIndex = midIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9}, 0));
    }
}
