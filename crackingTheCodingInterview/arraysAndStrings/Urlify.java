package src.src.crackingTheCodingInterview.arraysAndStrings;

public class Urlify {

    /*
    * Write a method to replace all spaces in a string with '%20'.
    * You may assume that the string has sufficient space at the end to hold the additional characters,
    * and that you are given the "true" length of the string.
    */

    String solution1(String s, int k) {
        char[] chars = s.toCharArray();
        s = null;
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            if (len == k) {
                break;
            }
            if (c != ' ') {
                sb.append(c);
            }else {
                sb.append("%20");
            }
            len++;

        }
        return sb.toString();
    }

    String solution2(String s, int k) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (len == k){
                break;
            }
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            }else {
                sb.append("%20");
            }
            len++;
        }
        return sb.toString();
    }

    void solution3(char[] str, int k) {

//        int spaces = (str.length - k)/2;
        int lastCharIndex = k - 1;
        int currentIndex = str.length - 1;
        while (lastCharIndex>=0) {

            char currentChar = str[lastCharIndex];
            if (currentChar == ' ') {
                str[currentIndex] = '0';
                currentIndex--;
                str[currentIndex] = '2';
                currentIndex--;
                str[currentIndex] = '%';
                currentIndex--;
            }else {
                str[currentIndex] = currentChar;
                currentIndex--;
            }
            lastCharIndex--;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Urlify().solution2("Mr John Smith ", 9));
        char [] input = new char[]{'M','r',' ','J','O','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        new Urlify().solution3(input, 13);
        System.out.println(input);
    }
}
