package src.src.crackingTheCodingInterview.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutations {

    /*
    Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    */

    boolean solution1(String input) {

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (c != ' ') {
                charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
            }

        }
        int oddCount = 0;
        for (Character c : charFrequencyMap.keySet()) {
            if (charFrequencyMap.get(c) % 2 == 1) {
                oddCount++;
            }
            if(oddCount == 2) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePermutations p = new PalindromePermutations();
        System.out.println(p.solution1("aaba"));
    }

}
