package src.src.crackingTheCodingInterview.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    /*
    * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
    */

    boolean solution1(String str1, String str2) {
        if (str1.length() != str2.length()){
            return false;
        }
        Map<Character, Integer> str1Map = createCharacterFrequencyMap(str1);
        Map<Character, Integer> str2Map = createCharacterFrequencyMap(str2);
        if (str1Map.size() != str2Map.size()){
            return false;
        }
        for (Character c: str1Map.keySet()){
            if (!str2Map.containsKey(c) || (str1Map.get(c) != str2Map.get(c))){
                return false;
            }
        }
        return true;
    }

    Map<Character, Integer> createCharacterFrequencyMap(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            result.put(c1, result.getOrDefault(c1, 0) + 1);
        }
        return result;
    }

    public void main(String[] args) {
        System.out.println(solution1("abc", "ab"));
    }
}
