package src.src.crackingTheCodingInterview.arraysAndStrings;

public class StringRotation {

    /*
    * Assume you have a method isSubstring which checks if one word is a substring
    * of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl
    * using only one call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat" ).
    */

//    concatenate s1 with itself that way if s2 is a rotation of s1 it will definitely a substring of s1 + s1
//    but we must do a length check before this as above case still be satisfied if s2 is a small string
//    example s1 = wassup , s2 = was



    boolean solution1(String s1, String s2) {
        if (s1.length()!=s2.length()){
            return false;
        }
        String concatenated = s1+s1;
        return isSubstring(concatenated, s2);
    }

    boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }



}
