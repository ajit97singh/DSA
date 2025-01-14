package src.src.algoexpert.medium;

import java.util.*;

public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        HashSet<Integer> visited = new HashSet<>();
        int currentIdx = 0;
        while (visited.size() < array.length) {
            if (visited.contains(currentIdx)) {
                return false;
            }
            visited.add(currentIdx);
            currentIdx = currentIdx + array[currentIdx];
            if (currentIdx < 0) {
                while(currentIdx < 0) {
                    currentIdx += array.length;
                }
            }else if (currentIdx > array.length-1) {
                currentIdx = currentIdx % array.length;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,1,2};
        System.out.println(Arrays.toString(array));
        boolean x = hasSingleCycle(array);

    }
}
