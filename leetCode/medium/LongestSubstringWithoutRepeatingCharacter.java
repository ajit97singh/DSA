package src.src.leetCode.medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int leftPointer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLength = 0;

        outerLoop:
        while (true)  {

            for (int rightPointer = leftPointer; rightPointer < s.length(); rightPointer++ ) {
                if (!hashMap.containsKey(s.charAt(rightPointer))) {
                    hashMap.put(s.charAt(rightPointer), rightPointer);
                    maxLength = Math.max(maxLength, hashMap.size());
                    if (rightPointer == s.length()-1){
                        break outerLoop;
                    }
                }else {
                    leftPointer = hashMap.get(s.charAt(rightPointer));
                    leftPointer++;
                    hashMap.clear();
                    break;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
