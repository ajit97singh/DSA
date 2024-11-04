package src.src.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumNumberOfMovesToSeatEveryone {


    public static int minMovesToSeat(int[] seats, int[] students) {
        List<Integer> seat_list = new ArrayList<>(Arrays.stream(seats)
                .boxed()
                .toList());
        Collections.sort(seat_list);
        List<Integer> students_list = new ArrayList<>(Arrays.stream(students)
                .boxed()
                .toList());
        Collections.sort(students_list);

        int minMoves = 0;
        for(int i = 0; i < students_list.size(); i++){
            minMoves += Math.abs(seat_list.get(i) - students_list.get(i));
        }

        return minMoves;
    }

    public static void main(String[] args) {
        int[] seats = new int[]{3,1,5};
        int[] students = new int[]{2,7,4};
        int output = minMovesToSeat(seats, students);
        System.out.println(output);
    }
}
