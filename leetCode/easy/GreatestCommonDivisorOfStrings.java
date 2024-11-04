package src.src.leetCode.easy;

public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        String longer;
        String shorter;
        if(str1.length() >= str2.length()){
            longer = str1;
            shorter = str2;
        }else{
            longer = str2;
            shorter = str1;
        }
        int lLength = longer.length();
        int sLength = shorter.length();

        if(lLength == 0 || sLength == 0){
            return "";
        }
        String commmonString = shorter;
        int commonStringLength = sLength;
        int factor = 1;
        if (lLength % sLength != 0) {
            while (lLength % commonStringLength != 0) {
                if (sLength % factor == 0) {
                    commonStringLength = sLength / factor;
                    commmonString = shorter.substring(0, commonStringLength);
                }
                factor++;
            }
            factor--;
        }
        return getCommonString(commmonString, longer, shorter, factor);

    }

    private static String getCommonString(String commmonString, String longer, String shorter, int factor) {
        if(commmonString.repeat(longer.length() / commmonString.length()).equals(longer) &&
                commmonString.repeat(factor).equals(shorter)){
            return commmonString;
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }
}
