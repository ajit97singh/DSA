package src.src.leetCode.easy;

public class SquareRoot {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x <= 2) {
            return 1;
        }
        double delta = x;
        for (int ans = 1; ans <= x; ans++) {
            int result = ans * ans;
//            if(Math.abs(x - result)>delta){
//                return ans - 1;
//            }

            delta = x - result;

            if (delta == 0) {
                return ans;
            } else if (delta < 0) {
                return ans - 1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
