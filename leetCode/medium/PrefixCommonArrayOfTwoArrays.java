package src.src.leetCode.medium;

import java.util.HashSet;

public class PrefixCommonArrayOfTwoArrays {
    public static int[] solution(int[] A, int[] B) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int[] result = new int[A.length];

        if (A[0] == B[0]){
            result[0] = 1;
        }else{
            setA.add(A[0]);
            setB.add(B[0]);
        }

        for(int i = 1; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            int increment = 0;
            if (a==b){
                increment++;
            }else {
                setA.add(a);
                setB.add(b);
                if(setA.contains(b)){
                    increment++;
                    setA.remove(b);
                }
                if (setB.contains(a)) {
                    increment++;
                    setB.remove(a);
                }
            }
            result[i] = result[i-1] + increment;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,3,2,4};
        int[] B = new int[]{3,1,2,4};
        int[] res = solution(A, B);
    }
}
