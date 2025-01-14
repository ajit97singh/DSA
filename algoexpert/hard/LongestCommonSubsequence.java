package src.src.algoexpert.hard;

import java.util.*;

public class LongestCommonSubsequence {
    public static List<Character> longestCommonSubsequence(
            String str1, String str2
    ) {
        if (str1.length() == 0 || str2.length()==0){
            return new ArrayList<>();
        }
        // Write your code here.
        String [][] matrix = new String[str1.length()][str2.length()];
        matrix[0][0] = (str1.charAt(0) == str2.charAt(0))? String.valueOf(str2.charAt(0)):"";

        for(int row = 0; row < str1.length(); row++) {
            for(int col = 0; col < str2.length(); col++) {

                // check if chartAt row of str1 & col of str2 are equal
                boolean equalChars = str1.charAt(row) == str2.charAt(col);
                // upper string
                String upper = "";
                if (row > 0){
                    upper = matrix[row-1][col];
                }
                // left score
                String left = "";
                if (col > 0){
                    left = matrix[row][col-1];
                }
                // set current
                String longer = upper.length()>left.length()? upper:left;
                if (equalChars && row>0&&col>0) {
                    longer = matrix[row-1][col-1] + String.valueOf(str1.charAt(row));
                }
                matrix[row][col] = longer;

            }
        }

        List<Character> result = new ArrayList<>();
        for (Character ch: matrix[str1.length()-1][str2.length()-1].toCharArray()) {
            result.add(ch);
        }
        return result;
    }


    public static void main(String[] args) {
        List<Character> result = longestCommonSubsequence("ZXVVYZW","XKYKZPW");
        result = null;
    }
}
