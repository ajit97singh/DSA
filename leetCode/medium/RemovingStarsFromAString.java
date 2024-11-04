package src.src.leetCode.medium;

import java.util.Stack;

public class RemovingStarsFromAString {
    /*
    * You are given a string s, which contains stars *.
    * In one operation, you can:
    * Choose a star in s.
    * Remove the closest non-star character to its left, as well as remove the star itself.
    * Return the string after all stars have been removed.
        Note:
            The input will be generated such that the operation is always possible.
            It can be shown that the resulting string will always be unique.
    */

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character character: s.toCharArray()){
            stack.push(character);
        }
        int charsToSkip = 0;
        StringBuilder finalString = new StringBuilder();
        while (!stack.isEmpty()){

            Character character = stack.pop();

            if(character == '*'){
                charsToSkip++;
                continue;
            }

            if (charsToSkip > 0) {
                charsToSkip--;
            } else {
                finalString.append(character);
            }

        }

        return finalString.reverse().toString();
    }

    public static void main(String[] args) {
        // output : "lecoe"
        System.out.println(removeStars("leet**cod*e"));
    }
}
