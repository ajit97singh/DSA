package src.src.algoexpert.hard;

import java.util.*;

public class SameBST {
    // given two arrays of integers, a BST is formed by adding them from left to right
    // return whether both represent the same BST,
    // not allowed to construct any BST

    public boolean solution(ArrayList<Integer> arrayOne, ArrayList<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayOne = new ArrayList<>(List.of(10, 15, 8, 12, 94, 81, 5, 2, 10));
        ArrayList<Integer> arrayTwo = new ArrayList<>(List.of(10, 8, 5, 15, 2, 10, 12, 94, 81));
        boolean res = new SameBST().solution(arrayOne, arrayTwo);
        res = false;
    }

}
