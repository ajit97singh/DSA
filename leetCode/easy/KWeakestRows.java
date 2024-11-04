package src.src.leetCode.easy;

import java.util.*;

public class KWeakestRows {

    public static int[] kWeakestRows(int[][] mat, int k) {
        List<Map<String, Integer>> strengths = new ArrayList<>();
        for (int rowNumber = 0; rowNumber< mat.length; rowNumber++) {
            int rowStrength = mat[rowNumber].length;
            for (int personIndex = 0; personIndex < mat[rowStrength].length; personIndex++) {
                if (mat[rowNumber][personIndex] == 0) {
                    rowStrength = personIndex;
                    break;
                }
            }
            Map<String, Integer> indexValueMap = new HashMap<>();
            indexValueMap.put("value", rowStrength);
            indexValueMap.put("index", rowNumber);
            strengths.add(indexValueMap);
        }
//        strengths.sort(Comparator.comparing());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
//            result[i] = strengths.get(i).getIndex();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(
                new int[][]{{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}}, 2)));
    }
}

