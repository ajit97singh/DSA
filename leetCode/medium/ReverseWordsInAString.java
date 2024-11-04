package src.src.leetCode.medium;

import java.util.Stack;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {

        Stack<String> words = new Stack<>();
        StringBuilder currentWord = new StringBuilder();
        s = s + " ";
        for(char character: s.toCharArray()){
            if(character == ' '){
                if(!currentWord.toString().isBlank()){
                    words.push(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            }else{
                currentWord.append(character);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!words.isEmpty()){
            result.append(words.pop());
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
