package src.src.algoexpert.hard;

public class LongestSubarrayWithSum {
    public int[] solution(int[] array, int target) {


        int left = 0;
        int right = 0;
        int sum = array[0];
        int length = 1;
        int startingIndex = -1;
        int endingIndex = -1;

        while (left <= right) {
            if (sum <= target) {
                if ((right - left + 1) >= length && sum == target) {
                    length = right - left + 1;
                    startingIndex = left;
                    endingIndex = right;
                }
                right++;
                if (right < array.length) {
                    sum += array[right];
                }else {
                    break;
                }
            }else {
                if (left < right) {
                    sum -= array[left];
                    left++;
                }else {
                    right++;
                    if (right < array.length) {
                        sum += array[right];
                    }else {
                        break;
                    }
                }
            }
        }
        return endingIndex >= 0 ? new int[]{startingIndex, endingIndex} : new int[]{};
    }

    public static void main(String [] args) {
        int[] res = new LongestSubarrayWithSum().solution(new int[]{1, 4, 10, 15, 31, 7, 1, 40, 0, 20, 1, 1, 1, 1, 2, 1}, 0);
    }

}
