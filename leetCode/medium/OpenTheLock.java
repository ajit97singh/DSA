package src.src.leetCode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class OpenTheLock {
    /*
    * You have a lock in front of you with 4 circular wheels.
    * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
    * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
    * Each move consists of turning one wheel one slot.
    * The lock initially starts at '0000', a string representing the state of the 4 wheels.
    * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
    * the wheels of the lock will stop turning and you will be unable to open it.
    * Given a target representing the value of the wheels that will unlock the lock,
    * return the minimum total number of turns required to open the lock, or -1 if it is impossible
    */
    public static int openLock(String[] deadends, String target) {
        HashSet<Integer> deadendsSet = new HashSet<>(List.of(deadends).stream().map(Integer::parseInt).collect(Collectors.toList()));
        Queue<Integer> currentLevelElements = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        currentLevelElements.add(0);
        int depth = 0;

        if(deadendsSet.contains(0)){
            return -1;
        }

        while (!currentLevelElements.isEmpty()){
            // get element
            Integer currentCode = currentLevelElements.remove();
            if(!deadendsSet.contains(currentCode)){
                if(currentCode == Integer.parseInt(target)){
                    return depth;
                }
                // process element
                deadendsSet.add(currentCode);

                // add children
                for(int i = 0; i < target.length(); i++){

                    // create children

                    StringBuilder codeString = new StringBuilder(String.valueOf(currentCode));
                    if(codeString.length()==1){
                        codeString.insert(0, "000");
                    }else if (codeString.length()==2){
                        codeString.insert(0, "00");
                    } else if (codeString.length()==3){
                        codeString.insert(0, "0");
                    }
                    char digit = codeString.charAt(target.length() - 1 - i);

                    int forwardRotationCode;
                    int reverseRotationCode;

                    if(digit =='9'){
                        forwardRotationCode = currentCode - ( 9 * (int) Math.pow(10, i));
                    }else {
                        forwardRotationCode = currentCode + (int) Math.pow(10, i);
                    }
                    if(digit =='0'){
                        reverseRotationCode = currentCode + (9 * (int) Math.pow(10, i));
                    }else {
                        reverseRotationCode = currentCode - (int) Math.pow(10, i);
                    }

                    // add to queue
                    if(!deadendsSet.contains(forwardRotationCode)){

                        queue.add(forwardRotationCode);
                    }
                    if(!deadendsSet.contains(reverseRotationCode)){
                        queue.add(reverseRotationCode);
                    }

                }
            }
            if(currentLevelElements.isEmpty()){
                currentLevelElements.addAll(queue);
                queue.clear();
                depth++;
            }

        }

        return -1;
    }

    public static String getStringOfCode(int code, int size){
        StringBuilder codeStringBuilder = new StringBuilder(String.valueOf(code));
        int missingZeros = size - codeStringBuilder.length();
        while (missingZeros>0){
            codeStringBuilder.insert(0, "0");
            missingZeros--;
        }
        return codeStringBuilder.toString();
    }

    public static void main(String[] args) {
        //input
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        // output --> -6
        System.out.println(openLock(deadends, target));
    }
}
