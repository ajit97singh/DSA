package src.src.leetCode.easy;

public class IsSubsequence {
    public static boolean isSubsequence(String sub, String complete) {
        int subStringCurrentIndex = 0;
        for(int index=0; index < complete.length(); index++){
            if(complete.charAt(index) == sub.charAt(subStringCurrentIndex)){
                subStringCurrentIndex++;
            }
        }
        return subStringCurrentIndex == sub.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde"));
    }
}
