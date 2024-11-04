package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCompression {
    /*
    Given an array of characters chars, compress it using the following algorithm:
    Begin with an empty string s. For each group of consecutive repeating characters in chars:
    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
    Note that group lengths that are 10 or longer will be split into multiple characters in chars.
    After you are done modifying the input array, return the new length of the array.
    You must write an algorithm that uses only constant extra space.
    */

    public static int compress(char[] chars) {
        if (chars.length <= 1){
            return chars.length;
        }

        List<Character> result = new ArrayList<>();
        result.add(chars[0]);

        int index = 1;
        int current_character_count = 1;

        while(index < chars.length){
            if(chars[index] == chars[index - 1]){
                current_character_count += 1;
            } else{
                if(current_character_count>1){
                    result.addAll(Arrays.stream(String.valueOf(current_character_count).split("")).map(x -> x.charAt(0)).toList());
                }
                result.add(chars[index]);
                current_character_count = 1;
            }
            index ++;
        }
        if(current_character_count>1){
            result.addAll(Arrays.stream(String.valueOf(current_character_count).split("")).map(x -> x.charAt(0)).toList());
        }

        for(int i =0; i<result.size(); i++){
            chars[i] = result.get(i);
        }

        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a'}));
    }
}
