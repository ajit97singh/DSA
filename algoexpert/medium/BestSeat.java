package src.src.algoexpert.medium;

public class BestSeat {

    public int bestSeat(int[] seats) {
        // first find largest empty space ,
        int largestSequence = 0;
        int startIndex = 0;
        int currentSequence = 0;
        for (int i = 1; i < seats.length; i++) {

            if (seats[i] == 0) {
                currentSequence++;
            }else {
                if (currentSequence > largestSequence) {
                    largestSequence = currentSequence;
                    startIndex = i - currentSequence;
                }
                currentSequence = 0;
            }

        }

        // then find the middle of it
        System.out.println(startIndex);
        System.out.println(largestSequence);
        if (startIndex == 0) {
            return -1;
        }
        int moveForward = (largestSequence / 2);
        if (largestSequence % 2 == 0){
            moveForward--;
        }
        return startIndex + moveForward;
    }

    public static void main(String[] args) {

        int[] input = {1, 0, 0, 1};
        new BestSeat().bestSeat(input);
        int res = 12;

    }
}
