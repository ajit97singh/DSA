package src.src.Jovian;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CountListRotation {

    public static int countRotation(List<Integer> inputArray) {
        int leftIndex = 0;
        int rightIndex = inputArray.size() - 1;
        int midIndex = (rightIndex + leftIndex) / 2;

        if (inputArray.isEmpty()) {
            return -1;
        } else if (inputArray.size() == 1) {
            return 0;
        } else if (inputArray.size() == 2 && (inputArray.get(1) > inputArray.get(0))) {
            return 0;
        }else if (inputArray.size() == 2 && (inputArray.get(1) < inputArray.get(0))) {
            return 1;
        } else if (inputArray.get(midIndex) > inputArray.get(leftIndex) && inputArray.get(midIndex) < inputArray.get(rightIndex)) {
            return 0;
        }

        AtomicReference<Boolean> found = new AtomicReference<>(false);

        while (!found.get()) {
            midIndex = (rightIndex + leftIndex) / 2;
            if (inputArray.get(midIndex) > inputArray.get(midIndex + 1) && inputArray.get(midIndex) > inputArray.get(midIndex - 1)) {
                found.set(true);
            } else if (inputArray.get(midIndex) > inputArray.get(rightIndex)) {
                leftIndex = midIndex;
            } else if (inputArray.get(midIndex) < inputArray.get(rightIndex)) {
                rightIndex = midIndex;
            }
        }
        return midIndex + 1;
    }

    public static void main(String[] args) {
        List<List<Integer>> tests = new ArrayList<>();
//        Add test cases
        tests.add(new ArrayList<>());
        tests.add(List.of(1));
        tests.add(List.of(2, 1));
        tests.add(List.of(1, 2));
        tests.add(List.of(3, 1, 2));
        tests.add(List.of(4, 5, 1, 2, 3));
        tests.add(List.of(2000, 4000, 1, 2, 3, 4, 12, 412, 719, 1000));

        tests.forEach(test -> System.out.println(countRotation(test)));
    }

}
