package src.src.crackingTheCodingInterview.recusrsionAndDP;
import java.util.*;

public class ParenthesisPermutations {

    List<String> getPerms(int pairs) {

        List<String> result = new ArrayList<>();
        if (pairs > 0) {
            recursion(pairs, 0,0,"", result);
        }
        return result;
    }

    void recursion(int n, int open, int close, String str,  List<String> res) {
        if (open == n && close == n) {
            res.add(str);
            return;
        }

        if (open < n) {
            recursion(n, open+1, close, str+"(", res);
        }
        if (open > close) {
            recursion(n, open, close+1, str+")", res);
        }

    }


    public static void main(String [] args) {

        List<String> res = new ParenthesisPermutations().getPerms(1);
        res = null;


    }



}
