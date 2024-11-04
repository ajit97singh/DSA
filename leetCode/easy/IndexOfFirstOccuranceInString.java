package src.src.leetCode.easy;

public class IndexOfFirstOccuranceInString {
    public static int strStr(String haystack, String needle) {
        boolean flag = false;
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if(haystackLength==0||needleLength==0||needleLength>haystackLength){
            return -1;
        }
        for(int haystackIndex = 0; haystackIndex < haystack.length(); haystackIndex++){
            String currentCharacter = String.valueOf(haystack.charAt(haystackIndex));
            if (currentCharacter.equals(String.valueOf(needle.charAt(0)))){
                for(int needleIndex = 0; needleIndex<needle.length();needleIndex++){
                    if (((haystackIndex+needleIndex) < haystack.length()) && (needle.charAt(needleIndex)==haystack.charAt(haystackIndex+needleIndex))){
                        flag=true;
                    }else {
                        flag=false;
                    }
                    if(!flag){
                        break;
                    }
                }
            }
            if(flag){
                return haystackIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }
}
