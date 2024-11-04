package src.src.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<String, Integer> convertor = new HashMap<>();
        convertor.put("I", 1);
        convertor.put("V", 5);
        convertor.put("X", 10);
        convertor.put("L", 50);
        convertor.put("C", 100);
        convertor.put("D", 500);
        convertor.put("M", 1000);

        int currentVal = convertor.get(String.valueOf(s.charAt(0)));
        if (s.length() == 1) {
            return currentVal;
        }
        int result = 0;
        int nextVal = 0;
        for (int i = 0; i < s.length(); i++) {

            currentVal = convertor.get(String.valueOf(s.charAt(i)));
            if(i<s.length()-1){
                nextVal = convertor.get(String.valueOf(s.charAt(i + 1)));
            }else {
                nextVal = 0;
            }

            if (currentVal < nextVal) {
                result -= currentVal;
            } else {
                result += currentVal;
            }
        }
        return result;
    }


    public static void main(String [] args){

        System.out.println(romanToInt("XXX"));
    }
}