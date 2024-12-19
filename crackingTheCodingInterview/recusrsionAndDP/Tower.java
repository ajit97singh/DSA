package src.src.crackingTheCodingInterview.recusrsionAndDP;

import java.util.HashSet;
import java.util.Stack;

public class Tower {

    Stack<Integer> stack = new Stack<>();
    int index;


    Tower(int i) {
        this.index = i;
    }

    void add(int i) {

        if ( !stack.isEmpty() && i >= stack.peek()) {
            System.out.println("Failed to add a bigger integer on top of tower");
        } else {
            stack.push(i);
        }
    }


    void moveDiskTo(Tower tower) {
        if (!this.stack.isEmpty()) {
            tower.add(this.stack.pop());
        }

    }


    void shiftDisks(int n, Tower dest, Tower buffer) {
        if (n>0) {

            shiftDisks(n-1, buffer, dest);
            moveDiskTo(dest);
            buffer.shiftDisks(n-1, dest, this);
        }
    }



    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];

        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i);
        }

        int numberOfDisks = 5;
        for (int disk = numberOfDisks; disk > 0; disk--) {
            towers[0].add(disk);
        }
        towers[0].shiftDisks(numberOfDisks, towers[2], towers[1]);
        int x = 12;


    }

}
