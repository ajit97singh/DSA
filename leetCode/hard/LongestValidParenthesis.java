package src.src.leetCode.hard;


import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char character = s.charAt(i);
            if (!characterStack.isEmpty() && (character == ')' && characterStack.peek() == '(')) {
                characterStack.pop();
                indexStack.pop();
            } else {
                characterStack.add(character);
                indexStack.add(i);
            }
        }
        int later = s.length() - 1;
        int maxLength = 0;
        while (!indexStack.isEmpty()) {
            int prev = indexStack.pop();
            int len = later - prev;
            maxLength = Math.max(maxLength, len);
            later = prev;
        }
        maxLength = Math.max(maxLength, later);
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "()(()";
        int res = longestValidParentheses(input);
        System.out.println(res);
    }
}
