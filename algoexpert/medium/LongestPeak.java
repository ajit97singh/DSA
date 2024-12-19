package src.src.algoexpert.medium;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        // Write your code here.
        // let's define a peak and find a peak and go outwards
        int maxPeak = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                int currentPeakLength = 3;
                //go left
                int left = i - 1;
                while (left > 0 && array[left - 1] < array[left]) {
                    currentPeakLength++;
                    left--;
                }

                // go right
                int right = i + 1;
                while (right < array.length - 1 && array[right] > array[right + 1]) {
                    currentPeakLength++;
                    right++;
                }
                maxPeak = Math.max(maxPeak, currentPeakLength);
                i = right;
            }
        }
        return maxPeak;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        int res = longestPeak(input);


    }
}
