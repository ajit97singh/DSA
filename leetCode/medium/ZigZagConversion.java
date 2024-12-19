package src.src.leetCode.medium;

import java.util.*;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        HashMap<Integer, List<Character>> grid = new HashMap<>();
        for (int i = 0; i< numRows; i++) {
            grid.put(i, new ArrayList<>());
        }

        int idx = 0;
        int blockLength = (2*numRows) - 2;
        while (idx < s.length()) {

            Character ch = s.charAt(idx);
            int x = idx % blockLength;
            int row = x < numRows? x: (numRows - 2 -(x-numRows));
            grid.get(row).add(ch);
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< numRows; i++) {
            List<Character> chs = grid.get(i);
            for (Character ch : chs) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String [] args) {

        String input = "PAYPALISHIRING";
        int rows = 3;
        String res = new ZigZagConversion().convert(input , rows);
        res = "PAHNAPLSIIGYIR";

    }

}
