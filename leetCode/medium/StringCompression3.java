package src.src.leetCode.medium;

public class StringCompression3 {

    /*
    Given a string word, compress it using the following algorithm:
    Begin with an empty string comp. While word is not empty, use the following operation:
    Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
    Append the length of the prefix followed by c to comp.
    Return the string comp.
    */

    public static String compressedString(String word) {

        if (word == null || word.length() == 0) {
            return word;
        }

        StringBuilder result = new StringBuilder();
        char previous = word.charAt(0);
        int maxFreq = 9;
        int currentCharFreq = 0;

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current == previous && currentCharFreq < maxFreq) {
                currentCharFreq++;
            }else {
                result.append(currentCharFreq);
                result.append(previous);
                previous = current;
                currentCharFreq = 1;
            }
        }
        result.append(currentCharFreq);
        result.append(previous);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }
}
