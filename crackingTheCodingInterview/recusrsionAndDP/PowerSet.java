package src.src.crackingTheCodingInterview.recusrsionAndDP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    List<List<Integer>> solution1(List<Integer> set) {
        List<List<Integer>> result = new ArrayList<>();
        for (Integer newElement: set) {
            result.addAll(addNewElement(result, newElement));
        }
        result.add(Collections.emptyList());
        return result;
    }

    List<List<Integer>> addNewElement(List<List<Integer>> result, Integer newElement) {
        List<List<Integer>> newSets = new ArrayList<>();
        newSets.add(Collections.singletonList(newElement));
        for(List<Integer> set: result) {
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(newElement);
            newSets.add(newSet);
        }
        return newSets;
    }


    List<String> solution2(String[] set) {

        int lengthOfSet = set.length;
        List<String> result = new ArrayList<>();
        // generate all binary combinations
        for (int i = 0; i < (1<<lengthOfSet); i++) {

            // select characters from string based on each bit of binary
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < lengthOfSet; index++) {
                int bitMask = 1 << index;
                if ((i & bitMask) != 0) {
                    sb.append(set[lengthOfSet-1-index]);
                }
            }
            if (!sb.isEmpty()) {
                result.add(sb.toString());
            }
        }
        result.add("");
        return result;
    }

    public static void main(String [] args) {
        List<Integer> input = List.of(1,2,3,4);
        List<List<Integer>> out = new PowerSet().solution1(input);

        List<String> out2 = new PowerSet().solution2(new String[]{"1", "2", "3", "4"});
        int x  =12;
    }
}