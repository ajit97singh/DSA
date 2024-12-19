package src.src.crackingTheCodingInterview.recusrsionAndDP;

import java.util.*;

class TowersOfHanoi {

    Stack<Integer> stack = new Stack<>();
    int index;


    TowersOfHanoi (int i) {
        this.index = i;
    }

    void add(int i) throws Exception {
        if ( !stack.isEmpty() && i >= stack.peek()) {
            System.out.println("Failed to add a bigger integer on top of tower");
        } else {
            stack.push(i);
        }
    }


    void moveDiskTo(TowersOfHanoi tower) throws Exception {
        if (!this.stack.isEmpty()) {
            Integer pop = this.stack.pop();
            tower.add(pop);
        }
    }


    void shiftDisksTo(int n, TowersOfHanoi destination, TowersOfHanoi buffer) throws Exception {
        if (n == 0) {
            return;
        }
        shiftDisksTo(n - 1, buffer, destination);
        moveDiskTo( destination );
        buffer.shiftDisksTo(n - 1, destination, this);

    }

    public static void main(String [] args) throws Exception {
        int n =3;
        TowersOfHanoi[] towers = new TowersOfHanoi[n];
        for(int i = 0; i<n; i++) {
            towers[i] = new TowersOfHanoi(i);
        }
        for(int i = n; i>0; i--) {
            towers[0].add(i);
        }

        towers[0].shiftDisksTo(n, towers[2], towers[1]);

        int x = 12;

    }

}
