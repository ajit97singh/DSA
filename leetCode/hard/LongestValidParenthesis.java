package src.src.leetCode.hard;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        // do a sliding window keeping count of open and closed parenthesis
        if (s == null || s.length() <= 1){
            return 0;
        }

        int left = 0;
        while(s.charAt(left) == ')'){
            left++;
        }

        int right = left;
        int openCount = 0;
        int closeCount = 0;
        int maxLength = 0;


        while (right < s.length()){
            if (s.charAt(right) == ')') {
                closeCount++;
            }else if(s.charAt(right) == '('){
                openCount++;
            }

            if (openCount == closeCount){
                maxLength = Math.max(maxLength, right - left + 1);
            }else if (openCount < closeCount){
                while (left<=right){
                    if (s.charAt(left) == '('){
                        openCount--;
                    }else {
                        closeCount--;
                    }
                    left++;
                    if (openCount == closeCount){
                        break;
                    }
                }
            }
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "(()()";
        int res = longestValidParentheses(input);
        System.out.println(res);
    }
}
