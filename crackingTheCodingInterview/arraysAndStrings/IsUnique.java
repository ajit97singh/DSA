package src.src.crackingTheCodingInterview.arraysAndStrings;

import java.util.HashSet;

public class IsUnique {
    /*
    1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?
    */

    public static boolean solution1(String str) {
        // O(N) time , O(N) space
        HashSet<Character> existingCharacters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(!existingCharacters.add(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean solution2(String str) {
        // O(N) time , O(1) space
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a'; // Subtracting 'a' converts the character to a zero-based index a->0, b->1..
            // (1 << val) creates a bitmask where only the val'th bit is set. for val = 2, 00000100
            int bitmask = 1 << val;
            // and check if the valth bit in checker is already set.
            if ((checker & bitmask) > 0) {
                return false;
            }else {
                //This updates checker to mark the current character as "seen."
                checker |= bitmask;
            }
        }
        return true;
    }

    // if we cant use any extra space then ues double for loop to match each character with other , O(n^2) time , space 0

    public static void main(String[] args) {
        System.out.println(solution1("aA"));
    }
}
