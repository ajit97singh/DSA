package src.src.crackingTheCodingInterview.recusrsionAndDP;

public class TripleStep {

    int solution(int steps) {

        if (steps == 0) {
            return 0;
        }else if(steps == 1) {
            return 1;
        }else if(steps == 2) {
            return 2;
        }else if(steps == 3) {
            return 4;
        }


        int[] possibilities = new int[steps - 1];
        possibilities[possibilities.length - 1] = 1;
        possibilities[possibilities.length - 2] = 2;
        possibilities[possibilities.length - 3] = 4;

        for (int stepsLeft = 4; stepsLeft < steps; stepsLeft++) {
            possibilities[possibilities.length - stepsLeft] = possibilities[possibilities.length - stepsLeft + 1] +
                    possibilities[possibilities.length - stepsLeft + 2] +
                    possibilities[possibilities.length - stepsLeft + 3];


        }
        return possibilities[0];

    }


    public static void main(String [] args) {

        int x = new TripleStep().solution(10);
        x = 10;

    }
}
