package src.src.leetCode.medium;

public class IntegerBreak {
    public static int integerBreak(int n) {
        if(n<2){
            return 0;
        }
        int currentVal = n;
        int result = 1;

        for(int num = 2; num<=currentVal; num++ ){
            if( currentVal%num == 0){
                currentVal-=num;
                result *= num;
                num = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
