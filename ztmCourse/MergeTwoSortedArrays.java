package src.src.ztmCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedArrays {
//    [1,3]  [2,5]
    public static List<Integer> solution(List<Integer> l1, List<Integer>l2){
        if(l1.isEmpty()){
            return l2;
        } else if (l2.isEmpty()) {
            return l1;
        }

        int l1Index = 0;
        int l2Index = 0;
        List<Integer> result = new ArrayList<>();
        while (true){
            if(l1Index==l1.size()){
                result.addAll(l2.subList(l2Index,l2.size()));
                break;
            } else if (l2Index==l2.size()) {
                result.addAll(l1.subList(l1Index,l1.size()));
                break;
            }else if(l1.get(l1Index) <= l2.get(l2Index)){
                result.add(l1.get(l1Index));
                l1Index++;
            }else if(l1.get(l1Index) > l2.get(l2Index)){
                result.add(l2.get(l2Index));
                l2Index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(-9,0);
        List<Integer> l2 = Arrays.asList(0,0,0,0,0,0,2,4);
        System.out.println(solution(l1, l2));
    }


}
