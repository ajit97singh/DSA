package src.src.crackingTheCodingInterview.mathPuzzles;

class Lockers {


    int solution(int lockerCount) {

        boolean [] lockers = new boolean[lockerCount];
        // false -> open
        // true -> closed (locker locked)

        for (int i = 1; i<lockerCount; i++) {

            int passNumber = i+1;
            int indexToFlip = passNumber - 1;
            while(indexToFlip < lockerCount) {
                lockers[indexToFlip] = !lockers[indexToFlip];
                indexToFlip += passNumber;
            }
        }

        int result = 0;
        for(boolean locked: lockers) {
            if (!locked) {
                result++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int res = new Lockers().solution(100);
        System.out.println(res);
    }
}