package src.src.crackingTheCodingInterview.recusrsionAndDP;

import java.util.*;

// 8.7 Write a method to compute all permutations of a string of unique characters.

public class StringPermutations {

    List<String> solution(String input) {
        List<String> result = new ArrayList<>();
        result.add("");
        for( char ch: input.toCharArray()){
            addCharacter(result, ch);
        }
        return result;
    }

    void addCharacter(List<String> strs, char ch) {
        List<String> updatedWithNewCharacter = new ArrayList<>();
        for(String str: strs) {
            for(int i = 0; i<=str.length(); i++) {
                updatedWithNewCharacter.add(insertCharAt(str, i, ch));
            }
        }
        strs.clear();
        strs.addAll(updatedWithNewCharacter);
    }


    String insertCharAt(String str, int index, char ch) {
        return str.substring(0, index) + ch + str.substring(index);
    }

    public static void main(String [] args) {
        List<String> res = new StringPermutations().solution("abc");
        res = null;
    }


}
