package src.src.leetCode.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        int longestCommonPrefixEndIndex = Math.min(strs[0].length(), strs[1].length());

        for (int wordIndex = 0; wordIndex < strs.length - 1; wordIndex++) {
            String currentWord = strs[wordIndex];
            String nextWord = strs[wordIndex + 1];
            int commonPrefixEndIndex = Math.min(currentWord.length(), nextWord.length());
            if(commonPrefixEndIndex<longestCommonPrefixEndIndex){
                longestCommonPrefixEndIndex = commonPrefixEndIndex;
            }
            for (int charIndex = 0; charIndex < commonPrefixEndIndex; charIndex++) {

                if (currentWord.charAt(charIndex) != nextWord.charAt(charIndex)) {
                    if (longestCommonPrefixEndIndex > charIndex) {
                        longestCommonPrefixEndIndex = charIndex;
                        break;
                    }
                }
            }
        }
        if (longestCommonPrefixEndIndex == 0) {
            return "";
        } else {
            return strs[0].substring(0, longestCommonPrefixEndIndex);
        }

    }
    public static void main(String [] args){
        System.out.println(longestCommonPrefix(new String[]{"dog", "doc", "doctor"}));
    }
}
