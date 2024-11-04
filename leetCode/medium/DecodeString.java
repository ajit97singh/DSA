package src.src.leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

    /*
    * Given an encoded string, return its decoded string.
    * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
    *  Note that k is guaranteed to be a positive integer.
    * You may assume that the input string is always valid; there are no extra white spaces,
    * square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits
    * and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
    * The test cases are generated so that the length of the output will never exceed 105.
    */

    // Unsolved
    public static String decodeString(String s) {

        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder middleStage = new StringBuilder();
        boolean stringStart = false;
        Stack<Character> stack = new Stack<>();

        for(char character: s.toCharArray()){
            if (character == '[' && stack.isEmpty()) {
                stringStart = true;
                stack.push(character);
                continue;
            } else if (character == '[') {
                stack.push(character);
            } else if (character == ']') {
                stack.pop();
                if(stack.isEmpty()){
                    stringStart = false;
                    StringBuilder integer = new StringBuilder();
                    while (!queue.isEmpty()){
                        integer.append(queue.remove());
                    }
                    result.append(middleStage.toString().repeat(Integer.parseInt(integer.toString())));
                    middleStage = new StringBuilder();
                    continue;
                }

            }
            if(stringStart){
                middleStage.append(character);
            }else {
                queue.add(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        // output --> "accaccacc"

        System.out.println(decodeString(input));
    }
}
