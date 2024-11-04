package src.src.leetCode.medium;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    /*
    Two strings are considered close if you can attain one from the other using the following operations:
    Operation 1: Swap any two existing characters.
    For example, abcde -> aecdb
    Operation 2: Transform every occurrence of one existing character into another existing character,
    and do the same with the other character.

    For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
    You can use the operations on either string as many times as necessary.
    Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
    */

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }

        HashMap<String, Integer> wordOneMap = new HashMap<>();
        HashMap<String, Integer> wordTwoMap = new HashMap<>();

        for(int i = 0; i < word1.length(); i++){
            updateMap(wordOneMap, String.valueOf(word1.charAt(i)));
            updateMap(wordTwoMap, String.valueOf(word2.charAt(i)));
        }
        HashSet<String> wordOneAlphabets = new HashSet<>(wordOneMap.keySet()) ;
        HashSet<String> wordTwoAlphabets = new HashSet<>(wordTwoMap.keySet()) ;
        List<Integer> wordOneAlphabetsFrequency =  new ArrayList<>(wordOneMap.values());
        List<Integer> wordTwoAlphabetsFrequency =  new ArrayList<>(wordTwoMap.values());

        if(wordOneAlphabetsFrequency.size()!=wordTwoAlphabetsFrequency.size()){
            return false;
        }
        boolean allMatch = wordOneAlphabetsFrequency.stream()
                .allMatch(element -> Collections.frequency(wordTwoAlphabetsFrequency, element) >= Collections.frequency(wordOneAlphabetsFrequency, element));

        wordOneAlphabetsFrequency.removeAll(wordTwoAlphabetsFrequency);
        return allMatch && wordOneAlphabets.containsAll(wordTwoAlphabets) && wordTwoAlphabets.containsAll(wordOneAlphabets) && wordOneAlphabetsFrequency.isEmpty();
    }

    public static void updateMap (HashMap<String, Integer> map, String key){
        map.compute(key, (k, v) -> v == null ? 1 : v + 1);
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("abbzzca", "babzzcz"));
    }


}
