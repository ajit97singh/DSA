package src.src.leetCode.easy;

public class NumbersWithEvenNumberDigits {
    public static int numbersWithEvenNumberDigits(int [] nums){

        int count = 0;

        for(int num: nums){
            num = Math.abs(num);
            while (num>=100){
                num /= 100;
            }
            if((num/100.0)>=0.1){
                count++ ;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numbersWithEvenNumberDigits(new int[] {12,345,2,6,7896}));
    }
}
