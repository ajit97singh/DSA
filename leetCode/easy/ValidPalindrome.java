package src.src.leetCode.easy;

import java.util.Objects;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(Objects.isNull(s)){
            return true;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int textLength = s.length();
        if(textLength < 2){
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                left.append(s.charAt(i));
                right.append(s.charAt(textLength - i - 1));
            }
        }
        return left.toString().contentEquals(right);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }


}
