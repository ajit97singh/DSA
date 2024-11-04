package src.src.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static List<Integer> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        result.add(List.of(1));

        for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {

            List<Integer> previousRow = result.get(rowIndex - 1);
            List<Integer> newRow = new ArrayList<>();
            int numElementsInNewRow = rowIndex + 1;

            for (int elementIndex = 0; elementIndex < numElementsInNewRow; elementIndex++) {
                if (elementIndex == 0) {
                    newRow.add(previousRow.get(0));
                } else if (elementIndex == numElementsInNewRow - 1) {
                    newRow.add(previousRow.get(rowIndex - 1));
                } else {
                    newRow.add(previousRow.get(elementIndex - 1) + previousRow.get(elementIndex));
                }
            }
            result.add(newRow);

        }

        return result.get(numRows-1);
    }

    public static void main(String[] args) {
        List<Integer> out = generate(3);
        java.util.Date dateFromLowestMobileNumber = new java.util.Date(5000000000000L);
        System.out.println(dateFromLowestMobileNumber);
    }
}
