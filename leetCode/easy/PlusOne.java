package src.src.leetCode.easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carryOver = 1;
        for(int i = digits.length - 1; i>=0; i--){
            digits[i] += carryOver;
            if(digits[i]>9){
                digits[i] -= 10;
                carryOver = 1;
            }else{
                carryOver = 0;
            }
        }
        if(carryOver==1){
            int [] newArray = new int [digits.length + 1];
            newArray[0] = 1;
            for(int i = 0; i <digits.length; i++ ){
                newArray[i+1] = digits[i];
            }
            return newArray;
        }
        return digits;
    }
}

