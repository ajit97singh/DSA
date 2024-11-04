package src.src.leetCode.easy;

public class AddBinary {
    public static String addBinary(String a, String b) {
        String result;
        if(a.length()>=b.length()){
            result  = "0" + a;
        }else {
            result = "0" + b;
        }
        int currentValue = 0;
        int carryOver = 0;
        int aValue = 0;
        int bValue = 0;
        for(int index = 0; index < result.length(); index++ ){
            if(index < a.length()){
                aValue = Integer.parseInt(a.substring(a.length()-1 - index, a.length()- index));
            }else {
                aValue = 0;
            }

            if(index < b.length()){
                bValue = Integer.parseInt(b.substring(b.length()-1 - index, b.length()- index));
            }else {
                bValue = 0;
            }

            currentValue = aValue + bValue + carryOver;
            // reset carry over after using it
            carryOver = 0;
            if (currentValue==2){
                currentValue = 0;
                carryOver = 1;
            } else if (currentValue==3) {
                currentValue = 1;
                carryOver = 1;
            }
            result = result.substring(0, result.length() - 1 - index) + currentValue + result.substring(result.length() - index, result.length());
        }
        if(Integer.parseInt(result.substring(0,1)) == 0){
            return result.substring(1);
        }else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
