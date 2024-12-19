package src.src.crackingTheCodingInterview.bitManipulation;

public class BinaryToString {


    String solution(double num) {
        StringBuilder sb = new StringBuilder(".");


        while (num > 0) {


            if (sb.length()>32) {
                return "ERROR";
            }


            double r = num * 2;
            if (r > 1) {
                sb.append("1");
                r = r - 1;
            }else {
                sb.append(0);
            }
            num = r;

        }
        return sb.toString();
    }


}
