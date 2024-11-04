package src.src.leetCode.medium;

public class SentenceSimilarity3 {


    /*
    * You are given two strings sentence1 and sentence2, each representing a sentence composed of words.
    * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    * Each word consists of only uppercase and lowercase English characters.
    * Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty)
    *  inside one of these sentences such that the two sentences become equal.
    * Note that the inserted sentence must be separated from existing words by spaces.
    * */

    // TODO: Unsolved


    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String longerSentence;
        String shorterSentence;
        if (sentence1.length() >= sentence2.length()) {
            longerSentence = sentence1;
            shorterSentence = sentence2;
        } else {
            longerSentence = sentence2;
            shorterSentence = sentence1;
        }

        String [] longerWords = longerSentence.split(" ");
        String [] shorterWords = shorterSentence.split(" ");

        int longerWordsLength = longerWords.length;
        int shorterWordsLength = shorterWords.length;
        int i = 0;
        return false;

    }

    public static void main(String[] args) {
        String sentence1 = "Eating";
        String sentence2 = "Lucccky";
        boolean result = areSentencesSimilar(sentence1, sentence2);
        System.out.println(result);
    }

}
