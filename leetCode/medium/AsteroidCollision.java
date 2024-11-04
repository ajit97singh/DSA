package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidCollision {

    /*
    * We are given an array asteroids of integers representing asteroids in a row.
    * For each asteroid, the absolute value represents its size, and the sign represents its direction
    * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
    * Find out the state of the asteroids after all collisions.
    * If two asteroids meet, the smaller one will explode.
    * If both are the same size, both will explode.
    * Two asteroids moving in the same direction will never meet.
    */
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids){

            if(stack.isEmpty() || asteroid>0){
                stack.push(asteroid);
            }else if(asteroid < 0 && stack.peek() < 0){
                stack.push(asteroid);
            }else if(asteroid < 0 ){

                while (!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroid)){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    stack.push(asteroid);
                }else if(stack.peek()<0){
                    stack.push(asteroid);
                } else if (stack.peek()==Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        // input
        int [] asteroids = new int[]{-2,-1,1,2};
        // output --> [5,10]
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }


}
