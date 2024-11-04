package src.src.leetCode.easy;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        StringBuilder finalS = new StringBuilder();
        StringBuilder finalT = new StringBuilder();
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !finalS.isEmpty()) {
                // backspace
                finalS.deleteCharAt(finalS.length()-1);
            } else if (s.charAt(i) != '#') {
                finalS.append(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && (!finalT.isEmpty())) {
                finalT.deleteCharAt(finalT.length()-1);
            } else if (t.charAt(i) != '#'){
                finalT.append(t.charAt(i));
            }
        }
        return finalS.toString().contentEquals(finalT);
    }

    public static boolean backspaceCompareOptimized(String s, String t) {

        int sPointer = s.length()-1;
        int tPointer = t.length()-1;

        while (sPointer >= 0 && tPointer >= 0) {
            // get char from s
            char fromS = s.charAt(sPointer);
            int skipsInS = 0;
            if (fromS == '#') {
                skipsInS += 2;
            }
            while (skipsInS > 0) {
                sPointer++;
            }
                // skip #
            // get char from t
            // compare
        }


        return true;
    }

    public static void parallelForLoopTest() throws InterruptedException {

        List<Integer> longList = IntStream.rangeClosed(1, 200).boxed().toList();

        long t0 = System.currentTimeMillis();
//        AtomicReference<String> atomicInteger = new AtomicReference();
//        for (Integer i : longList) {
//            sleep(500);
//        }
        long t1 = System.currentTimeMillis();

        ForkJoinPool customPool = new ForkJoinPool(2);

        ForkJoinPool.commonPool().submit(() -> {
            longList.parallelStream().forEach(i -> {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }).join();

        long t2 = System.currentTimeMillis();
        System.out.println("TASK ONE DONE");

        customPool.submit(() -> {
            longList.parallelStream().forEach(i -> {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }).join();


        long t3 = System.currentTimeMillis();
        System.out.println("Time Analysis Normal Loop");
        System.out.println(t1-t0);
        System.out.println("Time Common Pool");
        System.out.println(t2-t1);
        System.out.println("Custom Pool");
        System.out.println(t3-t2);
    }


    public static void main(String[] args) throws InterruptedException {
        parallelForLoopTest();
//        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

}
