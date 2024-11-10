package src.src.leetCode.medium;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    /*
    * You are given a 0-indexed binary string s having an even length.
    * A string is beautiful if it's possible to partition it into one or more substrings such that:
    * Each substring has an even length.
    * Each substring contains only 1's or only 0's.
    * You can change any character in s to 0 or 1.
    * Return the minimum number of changes required to make the string s beautiful.
    */

    public static int minChanges(String s) {
        int result = 0;
        // we iterate over each char from left to right in pairs and add 1 to result when pair elements are not identical
        for (int i = 0; i<s.length(); i+=2) {
            char left = s.charAt(i);
            char right = s.charAt(i+1);
            if ((left == '0' && right == '0') || (left == '1' && right == '1')) {
                continue;
            }else {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        minChanges("1001");
//        minChanges("10");
//        minChanges("000");
//        minChanges("101001");
//        minChanges("10100100");
        System.out.println(minChanges("1001"));
    }
}
