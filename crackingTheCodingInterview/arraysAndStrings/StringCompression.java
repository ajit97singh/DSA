package src.src.crackingTheCodingInterview.arraysAndStrings;

public class StringCompression {
    /*
    * Implement a method to perform basic string compression using the counts
    * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    * "compressed" string would not become smaller than the original string, your method should return
    * the original string. You can assume the string has only uppercase and lowercase letters (a - z)
    */

    String solution1(String input) {

        if (input == null || input.length() <= 1) return input;

        StringBuilder stringBuilder = new StringBuilder();
        int currentIndex = 0;
        int previousIndex = 0;
        int frequency = 0;

        while (currentIndex < input.length()) {
            char currentChar = input.charAt(currentIndex);
            char previousChar = input.charAt(previousIndex);
            if (currentChar == previousChar) {
                frequency++;
                currentIndex++;
            } else {
                stringBuilder.append(previousChar);
                stringBuilder.append(frequency);
                frequency = 0;
                previousIndex = currentIndex;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String [] args) {
        String input = "aabcccaabd";
        System.out.println(new StringCompression().solution1(input));
    }


}
