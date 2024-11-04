package src.src.leetCode.medium;

import java.util.HashMap;

public class LongestIdealSubsequence {
    /*
    * You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
    * t is a subsequence of the string s.
    * The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
    * Return the length of the longest ideal string.
    * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
    * Note that the alphabet order is not cyclic.
    * For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
    * */

    public static int longestIdealString(String s, int k) {
        int[] alpha = new int[26];
        int res=0;
        for(char ch:s.toCharArray()){
            int idx =ch-'a';
            int min = Math.max(0, idx-k);
            int max = Math.min(25, idx+k);
            int maxVal=0;
            for(int i=min; i<=max; i++){
                maxVal = Math.max(maxVal, alpha[i]);
            }
            alpha[idx] = maxVal+1;
            res = Math.max(res, maxVal+1);
        }
        return res;
    }

    public static void main(String[] args) {
        // input
        String s = "acfgbd";
        int k = 2;
        //output --> 4
        System.out.println(longestIdealString(s, k));
    }
}
