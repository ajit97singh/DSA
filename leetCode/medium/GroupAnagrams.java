package src.src.leetCode.medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for ( String str: strs ) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = Arrays.toString(ca);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
