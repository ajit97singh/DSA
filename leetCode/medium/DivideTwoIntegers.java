package src.src.leetCode.medium;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {

        Double quotient = 0.0;
        boolean dividendNegative = false;
        boolean divisorNegative = false;
        int posDividend = dividend;
        int posDivisor = divisor;
        if (dividend<0){
            dividendNegative = true;
            if(dividend == Integer.MIN_VALUE){
                posDividend = Integer.MAX_VALUE;
            }else {
                posDividend = -dividend;
            }

        }
        if (divisor < 0){
            divisorNegative = true;
            if (posDivisor == Integer.MIN_VALUE) {
                posDivisor = Integer.MAX_VALUE;
            }else {
                posDivisor = -divisor;
            }
        }

        if (posDividend == 0 || posDivisor == 0) {
            return 0;
        }
        if (posDivisor != 1) {
            while((posDividend>=posDivisor) && (quotient < Math.pow(2, 31) - 2)){
                posDividend -= posDivisor;
                quotient ++;
            }
        } else {
            if ((dividendNegative && divisorNegative) || (!dividendNegative && !divisorNegative)) {
                if (dividend == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return posDividend;
            }
            return dividend*divisor;
        }


        if((dividendNegative && divisorNegative) || !(dividendNegative || divisorNegative)){
            return quotient.intValue();
        }else{
            return -(quotient.intValue());
        }

    }

    public static void main(String[] args) {
        System.out.println(divide(-1, -1));
    }
}
