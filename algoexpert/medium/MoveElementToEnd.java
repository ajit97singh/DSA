package src.src.algoexpert.medium;
import java.util.*;

public class MoveElementToEnd {

    public List<Integer> moveElementToEnd( List<Integer> array, int toMove) {
        // Write your code here.
        int leftPointer = 0;
        int rightPointer = array.size() - 1;

        while (leftPointer < rightPointer) {
            int leftElement = array.get(leftPointer);
            if (leftElement == toMove) {

                while (rightPointer>0 && array.get(rightPointer) == toMove) {
                    rightPointer--;
                }

                int rightElement = array.get(rightPointer);
                array.set(leftPointer, rightElement);
                array.set(rightPointer, leftElement);
                rightPointer--;
            }
            leftPointer++;

        }
        return array;
    }

    public static void main(String[] args) {
        int toMove = 5;
        Integer[] input = {5, 1, 2, 5, 5, 3, 4, 6, 7, 5, 8, 9, 10, 11, 5, 5, 12};

        List<Integer> res = new MoveElementToEnd().moveElementToEnd(Arrays.asList(input), toMove);
        System.out.println(res);
    }
}
