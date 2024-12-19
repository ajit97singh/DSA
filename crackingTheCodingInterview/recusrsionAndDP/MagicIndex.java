package src.src.crackingTheCodingInterview.recusrsionAndDP;

public class MagicIndex {


    // given the sorted array we can assign left and right boundary/pointers
    // check if they are the magic index then check if the mid index is magic and
    // if arr[mid] > mid them recursive call with leftBound same and rightBound as midIndex and
    // base case will be left bound == rightBound
//				 [0,1,2,3,4,5,06,07]
    // test case [-10,0,2,]

    int solution(int[] array) {

        int leftBound = 0;
        int rightBound = array.length-1;

//        if ((array[rightBound]<rightBound) || (array[leftBound] > leftBound)) {
//
//            return -1;
//        }
        return dfs(array, leftBound, rightBound);
    }

    int dfs(int[] array, int leftBound, int rightBound) {

         int midIndex = (leftBound + rightBound)/2;

        // check magic
        if (array[leftBound] == leftBound) {
            return leftBound;
        } else if (array[rightBound] == rightBound){
            return rightBound;
        } else if (array[midIndex] == midIndex) {
            return midIndex;
        }

        if (leftBound >= rightBound) {
            return -1;
        }

        if (array[midIndex] > midIndex) {
            // check left
            return dfs(array, leftBound, midIndex-1);
        } else {
            //check right
            return dfs(array, midIndex+1, rightBound);
        }
    }

    public static void main(String[] args) {
//        2,3,4,5,6,7,100
//        -1,-2,-3,-4,-5,1,2
//        -1,-2,-3,-4,-5,5,9
        int[] input = {-1,-2,-3,-4,-5,5,5,5,5,5,5,5,9,10,11,111,11111};
        int res = new MagicIndex().solution(input);
        System.out.println(res);
    }




}
