package src.src.crackingTheCodingInterview.recusrsionAndDP;

public class Coins {

    static int solution(int amount, int[] denoms, int index) {
        if (index == denoms.length-1){
            return 1;
        }
        int ways = 0;
        int denomAmount = denoms[index];
        for (int i = 0; i * denomAmount <= amount; i++ ) {

            int remainingAmount = amount - ( i * denomAmount) ;
            ways += solution(remainingAmount, denoms, index+1);
        }
        return ways;
    }


    static int better( int amount, int[] denoms, int index, int[][] map, String str) {
        if ( map[amount][index] > 0 ) {
            return map[amount][index];
        }

        if (index == denoms.length-1){
            return 1;
        }

        int denomAmount = denoms[index];
        int ways = 0;
        for ( int i = 0; i * denomAmount < amount; i++) {
            int remainingAmount = amount - (i * denomAmount);
            ways += better(remainingAmount, denoms, index+1, map, str+"+"+i+"x"+denomAmount);
        }
        map[amount][index] = ways;
        System.out.println(str);
        return ways;
    }

    public static void main(String [] args) {
        int amount = 50;
        int [] denoms = {50, 20 ,10};
        int [][] map = new int[amount+1][denoms.length];
        int res = solution(amount, denoms, 0);
        int resFast = better(amount, denoms, 0, map, "");
        boolean x = res == resFast;
        if (x) {
            res = 0;
        }

    }

}
