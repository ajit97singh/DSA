package src.src.leetCode.medium;

public class HouseRobber2 {

    int solution(int[] houses) {
        int [] lootSkippingFirst = new int[houses.length-2];
        int [] lootSkippingLast = new int[houses.length-2];

        lootSkippingFirst[0] = houses[1];
        lootSkippingFirst[1] = Math.max(houses[1], houses[2]);

        lootSkippingLast[0] = houses[0];
        lootSkippingLast[1] = Math.max(houses[1], houses[0]);

        for(int i = 3; i < houses.length-1; i++) {
            lootSkippingFirst[i-1] = Math.max(lootSkippingFirst[i-2], lootSkippingFirst[i-3] + houses[i]);
        }
        for(int i = 2; i < houses.length-2; i++) {
            lootSkippingLast[i] = Math.max(lootSkippingFirst[i-1], lootSkippingFirst[i-2] + houses[i]);
        }
        return Math.max(lootSkippingFirst[lootSkippingFirst.length-1], lootSkippingLast[lootSkippingLast.length-1]);
    }

    public static void main(String[] args) {
        int [] input = {1,2,3,4,1};
        int res = new HouseRobber2().solution(input);
        res = 12;
    }
}
