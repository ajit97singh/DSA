package src.src.algoexpert.hard;

import java.util.*;

public class ZigZagTraverse {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.

        List<Integer> result = new ArrayList<>();

        boolean movingDown = true;
        int rows = array.size();
        int cols = array.get(0).size();
        int row = 0;
        int col = 0;
        while (result.size() < rows*cols) {

            // add current element
            result.add(array.get(row).get(col));
            // if reached top move right and set direction downwards
            if (!movingDown && row==0 && col < cols-1) {
                col++;
                movingDown = true;
            }
            // if reached bottom move right and set direction upwards
            else if (movingDown && row==rows-1) {
                col++;
                movingDown = false;
            }
            // if reached left move down and set direction upwards
            else if (movingDown && col==0) {
                row++;
                movingDown = false;
            }
            // if reached right move down and set direction downwards
            else if (!movingDown && col==cols-1) {
                row++;
                movingDown = true;
            }
            // check direction and move in that direction

            else {
                if (movingDown) {
                    row++;
                    col--;
                }else {
                    row--;
                    col++;
                }
            }

        }


        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> row1 = List.of(1,3,4,10);
        List<Integer> row2 = List.of(2,5,9,11);
        List<Integer> row3 = List.of(6,8,12,15);
        List<Integer> row4 = List.of(7,13,14,16);
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);
        List<Integer> out = zigzagTraverse(input);
        out = null;


    }

}
