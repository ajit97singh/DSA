package src.src.ztmCourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleInterviewQuestion {
// Check if any pair of elements has sum == target

    public Boolean checkSum(ArrayList<Integer> list, Integer target){
        // brute force
//        for(int i = 0; i<list.size()-1; i++){
//            for(int j = i+1; j<list.size()-1; j++){
//                int total = list.get(i) + list.get(j);
//                if(total == sum){
//                    return true;
//                }
//            }
//        }
//        return false;
//        For sorted array
//        int leftIndex = 0;
//        int rightIndex = list.size() -1;
//        while (leftIndex < rightIndex){
//            int sum = list.get(leftIndex) + list.get(rightIndex);
//            if(sum==target){
//                return true;
//            } else if (sum<target) {
//                leftIndex++;
//            }else {
//                rightIndex++;
//            }
//        }
//        return false;
        // For unsorted
        HashSet<Integer> set = new HashSet<>();
//        sol 1
//        for(Integer element: list){
//            int compliment = target - element;
//            if(set.contains(compliment)){
//                return true;
//            }else {
//                set.add(element);
//            }
//        }
//        sol2
//        AtomicBoolean answer = new AtomicBoolean(false);
//        list.forEach(element -> {
//            int compliment = target - element;
//            if(set.contains(compliment)){
//                answer.set(true);
//            }else {
//                set.add(element);
//            }
//        });
//        sol3
        return list.stream().anyMatch(element -> {
            int compliment = target - element;
            if(set.contains(compliment)){
                return true;
            }else {
                set.add(element);
            };
            return false;
        });
    }


}
