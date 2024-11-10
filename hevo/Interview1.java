package src.src.hevo;

import java.util.ArrayList;

public class Interview1 {
//     tell if  a number is present in a infinite list
// return boolean , only integers, it's sorted



//     0,1,1,2,3,4,4,5,6,7,8,9,9,000......
    //

    public static boolean solution(ArrayList<Integer> arr, int target) {

        int startIndex = 0;
        int startElement = arr.get(startIndex); // 1
        int endIndex = target; // 6
        int endElement = arr.get(endIndex); // 15


        // find search space in incrementing powers
        while (target > endElement) {
            startIndex = endIndex;
            startElement = arr.get(startIndex);
            endIndex*=target;
            endElement = arr.get(endIndex);
        }

        int currentIndex = (int)(endIndex + startIndex)/2; // 6 + 0/2 --> 3
        int currentElement = arr.get(currentIndex); // --> 12

        if (currentElement == target || startElement == target ||endElement == target) {
            return true;
        }

        // do a bin search
        while (endIndex - startIndex > 1) {
            currentIndex = (int)(endIndex + startIndex)/2; // 3 + 0/2 --> 1
            currentElement = arr.get(currentIndex); // --> 1

            if (currentElement == target || startElement == target ||endElement == target) {
                return true;
            }else {
                if (currentElement > target) { //  12 > 6
                    endIndex = currentIndex; // 3
                    endElement = currentElement; // 12
                } else if (currentElement < target) {
                    startIndex = currentIndex; // 0
                    startElement = currentElement; // 1
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(10);

        int target = 0;
        for (int i = 11; i < 1000; i++) {
            arr.add(i);
        }



        System.out.println(solution(arr, target));
    }
}
