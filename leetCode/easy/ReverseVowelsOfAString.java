package src.src.leetCode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ReverseVowelsOfAString {

    public static String reverseVowels(String s) {

        HashSet<String> vowels = new HashSet<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        List<String> vowelList = new ArrayList<>();
        List<String> alphabetList = new ArrayList<>();

        for(char alphabet: s.toCharArray()){
            if(vowels.contains(String.valueOf(alphabet).toLowerCase())){
                vowelList.add(String.valueOf(alphabet));
                alphabetList.add(null);
            }else{
                alphabetList.add(String.valueOf(alphabet));
            }
        }
        StringBuilder result = new StringBuilder();
        int vowelCount = vowelList.size();
        for(int i=0; i<alphabetList.size(); i++){
            if(Objects.nonNull(alphabetList.get(i))){
                result.append(alphabetList.get(i));
            }else {
                result.append(vowelList.get(vowelCount - 1));
                vowelCount--;
            }
        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
