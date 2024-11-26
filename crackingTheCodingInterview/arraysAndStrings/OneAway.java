package src.src.crackingTheCodingInterview.arraysAndStrings;

class OneAway {
    /*
    * There are three types of edits that can be performed on strings:
    * insert a character,remove a character, or replace a character.
    * Given two strings, write a function to check if they are one edit (or zero edits) away.
    */

    boolean solution1(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();
        if ((lenA - lenB) > 1){
            return false;
        } else if (lenA == lenB){
            return checkUsingReplacement(a,b);
        }else {
            if (lenA > lenB){
                return checkUsingDeletion(a,b);
            }else {
                return checkUsingDeletion(b,a);
            }
        }
    }


    boolean checkUsingDeletion(String longer, String shorter) {
        int charsSkipped = 0;
        int shorterIndex = 0;
        for (int longerIndex = 0; longerIndex < longer.length(); longerIndex++) {
            if (shorterIndex < shorter.length() && longer.charAt(longerIndex) == shorter.charAt(shorterIndex)){
                shorterIndex++;
            }else {
                charsSkipped++;
            }
            if (charsSkipped==2){
                return false;
            }
        }
        return true;
    }

    boolean checkUsingReplacement(String a, String b) {
        int charsMismatch = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)){
                charsMismatch++;
            }
            if (charsMismatch == 2){
                return false;
            }
        }
        return true;
    }



     public static void main(String[] args) {
        System.out.println(new OneAway().solution1("aac", "aab"));
    }

}
