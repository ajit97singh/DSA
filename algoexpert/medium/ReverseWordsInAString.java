package src.src.algoexpert.medium;

import java.util.*;

public class ReverseWordsInAString {
    public static String reverseWordsInString(String string) {
        // Write your code here.
        Stack<String> stack = new Stack<>();
        boolean traversingWord = string.charAt(0)!=' '?true:false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            Character currentCh = string.charAt(i);
            if (traversingWord && currentCh != ' '){
                sb.append(currentCh);
            }else if (traversingWord && currentCh == ' ') {
                stack.push(sb.toString());
                stack.push(" ");
                sb = new StringBuilder();
                traversingWord = false;
            }else if (!traversingWord && currentCh == ' ') {
                stack.push(" ");
            }else {
                traversingWord = true;
                sb.append(currentCh);
            }
        }
        if (sb.length()>0){
            stack.push(sb.toString());
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "best! the is AlgoExpert";
        String out = reverseWordsInString(input);
        out = " -";
    }
}
