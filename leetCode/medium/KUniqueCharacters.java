package src.src.leetCode.medium;

import java.util.HashSet;

public class KUniqueCharacters {

    /*
    * Have the function KUniqueCharacters(str) take the str parameter being passed and find the longest substring that contains k unique characters,
    * where k will be the first character from the string.
    * The substring will start from the second position in the string because the first character will be the integer k.
    * For example: if str is "2aabbacbaa" there are several substrings that all contain 2 unique characters, namely: ["aabba", "ac", "cb", "ba"],
    * but your program should return "aabba" because it is the longest substring.
    * If there are multiple longest substrings, then return the first substring encountered with the longest length. k will range from 1 to 6.
     */

    public static String KUniqueCharacters(String str) {

        int unique = Integer.parseInt(String.valueOf(str.charAt(0)));
        String substring = str.substring(1);
        int rightPointer = 0;
        int leftPointer = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String resultString = "";
        HashSet<Character> set = new HashSet<>();
        boolean setSpilled = false;

        while (rightPointer <= substring.length() - 1) {

            if (set.size() < unique) {
                set.add(substring.charAt(rightPointer));
                stringBuilder.append(substring.charAt(rightPointer));
            } else if (set.size() == unique) {
                if(!set.add(substring.charAt(rightPointer))){
                    stringBuilder.append(substring.charAt(rightPointer));
                } else {
                    setSpilled = true;
                }
            }

            if (setSpilled) {
                set.clear();
                if (stringBuilder.toString().length()>=resultString.length()) {
                    resultString = stringBuilder.toString();
                }
                stringBuilder = new StringBuilder();
                while (substring.charAt(leftPointer) == substring.charAt(leftPointer+1)) {
                    leftPointer++;
                }
                leftPointer++;
                rightPointer = leftPointer;
                setSpilled = false;
                continue;
            }
            rightPointer++;
        }
        if (stringBuilder.toString().length()>=resultString.length()) {
            resultString = stringBuilder.toString();
        }
        return resultString;
    }

    public static void main (String[] args) {
        // keep this function call here
        String input = "3aabacbebebe";
        String output = KUniqueCharacters(input);
        System.out.print(output);
    }
}
