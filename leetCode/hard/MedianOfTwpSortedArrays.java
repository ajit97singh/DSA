package src.src.leetCode.hard;

public class MedianOfTwpSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idxOne = -1;
        int idxTwo = -1;
        int size = nums1.length + nums2.length;
        int medianIdx = size / 2;
        boolean isEven = size % 2 == 0;
        if (isEven){
            medianIdx--;
        }
        boolean medianInOne = false;
        int currentIdx = -1;

        while (currentIdx < medianIdx) {
            if ( idxOne+1 < nums1.length && idxTwo+1 < nums2.length) {
                if (nums1[idxOne+1] >= nums2[idxTwo+1]){
                    idxTwo++;
                    medianInOne = false;
                }else{
                    idxOne++;
                    medianInOne = true;
                }
            }else if (idxOne == nums1.length-1){
                idxTwo++;
                medianInOne = false;
            }else {
                idxOne++;
                medianInOne = true;
            }
            currentIdx++;
        }
        int medianLeft = medianInOne? nums1[idxOne] : nums2[idxTwo];
        int medianRight = medianLeft;
        if (isEven) {
            if ( idxOne+1 < nums1.length && idxTwo+1 < nums2.length) {
                medianRight = Math.min(nums1[idxOne + 1], nums2[idxTwo + 1]);
            }else if (idxOne == nums1.length-1){
                medianRight = nums2[idxTwo+1];
            }else {
                medianRight = nums1[idxOne+1];
            }
        }
        return (medianLeft + medianRight) / 2.0;
    }

    public static void main(String[] args) {
        int[] one = new int[]{1,2};
        int[] two = new int[]{3,4};
        double res = findMedianSortedArrays(one, two);
        res = 0;
    }
}
