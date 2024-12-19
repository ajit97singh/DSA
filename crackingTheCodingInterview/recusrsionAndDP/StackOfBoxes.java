package src.src.crackingTheCodingInterview.recusrsionAndDP;

import java.util.*;

public class StackOfBoxes {


    int solution(int[][] boxes) {

        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(boxes, (a,b) -> Integer.compare(b[2], a[2]));
        for(int i = 0; i < boxes.length; i++) {
            res = Math.max(res, makeStack(boxes, i, map));
        }
        return res;
    }

    int makeStack(int[][] boxes , int index, HashMap<String, Integer> map) {

        if (index == boxes.length) {
            return 0;
        }
        int baseHeight = boxes[index][2];
        String baseStr =  boxes[index][0] + "_"  + boxes[index][1] + "_" + boxes[index][2];
        if (map.containsKey(baseStr)) {
            return map.get(baseStr);
        }
        int height = 0;
        for (int i = index+1; i < boxes.length; i++) {
            int[] boxToStack = boxes[i];
            if ( isStackable(boxes[index], boxToStack) ) {
                height = Math.max(height, makeStack(boxes, i, map));
            }
        }
        map.put(baseStr, baseHeight + height);
        return baseHeight + height;
    }



    boolean isStackable(int[] base, int[] boxToStack) {
        return base[0]>boxToStack[0] && base[1]>boxToStack[1] && base[2]>boxToStack[2];
    }

    public static void main(String [] args) {
        int[][] boxes = {
                {1,1,1},
                {2,2,3},
//                {3,3,3},
                {3,3,4},
//                {4,4,6},
//                {5,5,5}
        };
        int res = new StackOfBoxes().solution(boxes);
        res = 10;

    }

}