package src.src.leetCode.medium;

import java.util.HashSet;

public class MaximumNumberOfVowelsInASubstringOfAGivenLength {
    /*
    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
    */

    public static int maxVowels(String s, int k) {

        HashSet<String> vowels = new HashSet<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        int vowelsCount = 0;

        for( int i = 0; i < k; i++ ){
            String alphabet = String.valueOf(s.charAt(i)).toLowerCase();
            if(vowels.contains(alphabet)){
                vowelsCount++;
            }
        }
        int maxVowels = vowelsCount;

        int leftIndex = 0;
        int rightIndex = k - 1;
        int stringLength = s.length();

        while (rightIndex < stringLength - 1){
            String toRemove = String.valueOf(s.charAt(leftIndex)).toLowerCase();
            String toAdd = String.valueOf(s.charAt(rightIndex + 1)).toLowerCase();
            if(vowels.contains(toRemove)){
                vowelsCount--;
            }
            if(vowels.contains(toAdd)){
                vowelsCount++;
            }
            leftIndex++;
            rightIndex++;
            maxVowels = Math.max(maxVowels, vowelsCount);
        }
        return maxVowels;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
