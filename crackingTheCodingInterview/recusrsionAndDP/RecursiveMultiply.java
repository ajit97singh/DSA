package src.src.crackingTheCodingInterview.recusrsionAndDP;

public
class RecursiveMultiply {

    int solution(int a, int b) {

        if ( a == 0 || b == 0 ) {
            return 0;
        }else if (a == 1) {
            return b;
        }else if (b == 1) {
            return a;
        }


        // let's first find which one is closest to a power of 2
        int pow2a = 1;
        while ((a - (1<<pow2a)) > 0) {
            pow2a++;
        }
        if ((a - (1<<(pow2a-1))) < (1<<pow2a - a)) {
            pow2a--;
        }
        int diffA =  a - (1<<pow2a);
        //
        int pow2b = 1;
        while ((b - (1<<pow2b)) > 0) {
            pow2b++;
        }
        if ((b - (1<<(pow2b-1))) < ((1<<pow2b) - b)) {
            pow2b--;
        }
        int diffB =  b - (1<<pow2b);


        int result = 1;
        if (Math.abs(diffA) >= Math.abs(diffB)) {
            result = a;
            result = result << pow2b;
            while (diffB != 0) {
                if (diffB > 0) {
                    result += a;
                    diffB--;
                }else {
                    result -= a;
                    diffB++;
                }
            }
        } else {
            result = b;
            result = result << pow2a;
            while (diffA != 0) {
                if (diffA > 0) {
                    result += b;
                    diffA--;
                }else {
                    result -= b;
                    diffA++;
                }
            }
        }
        return result;
    }

    int solution2(int a, int b) {

        int big = Math.max(a, b);
        int small = Math.min(a, b);

        int result = 0;

        int mask = 1;
        int powerOf2 = 0;

        while (powerOf2 < 16) {
            if ((small & (mask<<powerOf2)) != 0) {
                result += big << powerOf2;
            }
            powerOf2++;
        }


        return result;

    }

    public static void main(String[] args) {
        int res = new RecursiveMultiply().solution2(64, 129);
        System.out.println(res);

    }

}
