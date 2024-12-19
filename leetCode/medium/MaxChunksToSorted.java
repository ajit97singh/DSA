package src.src.leetCode.medium;

public class MaxChunksToSorted {

    public int solution(int [] input) {
        int max = 0;
        int chunks = 0;

        for (int i = 0; i < input.length; i++) {
            max = Math.max(max, input[i]);
            if (i == max) {
                chunks++;
            }
        }
        return chunks;
    }

}
