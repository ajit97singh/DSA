package src.src.GreyOrenge;

import java.util.HashMap;

public class TuringAssesment {


    public static int test(int [] woods){
        int result = 1;
        int max = 0;
        for (int wood : woods) {
            int optimalLength = 0;
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();
            for (int j = 0; j < woods.length; j++) {
                if (woods[j] == wood) {
                    optimalLength++;
                } else {
                    int remainingHeight = wood - woods[j];
                    if (remainingHeight > 0) {
                        if (frequencyMap.containsKey(remainingHeight)) {
                            optimalLength++;
                            frequencyMap.put(remainingHeight, frequencyMap.get(remainingHeight) - 1);
                        } else {
                            int frequency = frequencyMap.getOrDefault(wood, 0);
                            frequencyMap.put(wood, frequency + 1);
                        }
                    }
                }
            }
            result = Math.max(result, optimalLength);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] woods = {10 ,10 ,10 ,10, 3 ,10, 3, 4, 10};
        System.out.println(test(woods));
    }



}
