package src.src.leetCode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversePrefixOfAWord {

    /*
    * Given a 0-indexed string word and a character ch,
    * reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
    * If the character ch does not exist in word, do nothing.
    * For example, if word = "abcdefd" and ch = "d",
    * then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
    *  The resulting string will be "dcbaefd".
    * Return the resulting string.
    */

    public static String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        boolean characterExists = false;
        StringBuilder result = new StringBuilder();

        for(Character character: word.toCharArray()){
            if(character == ch && !characterExists){
                characterExists = true;
                stack.add(character);
                continue;
            }
            if (characterExists){
                queue.add(character);
            }else {
                stack.add(character);
            }
        }
        if(characterExists){
            while (!stack.isEmpty()){
                result.append(stack.pop());
            }
            while (!queue.isEmpty()){
                result.append(queue.remove());
            }
            return result.toString();
        }else {
            return word;
        }
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}