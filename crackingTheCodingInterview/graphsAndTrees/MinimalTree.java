package src.src.crackingTheCodingInterview.graphsAndTrees;



class MinimalTree {

    TreeNode solution(int[] input) {
        return solution(input, 0, input.length-1);
    }

    TreeNode solution(int[] array, int leftBound, int rightBound) {
        if (leftBound > rightBound) {
            return null;
        }
        int midNodeIndex = (leftBound + rightBound)/2;
        TreeNode head = new TreeNode(array[midNodeIndex]);
        head.left = solution(array, leftBound, midNodeIndex-1);
        head.right = solution(array, midNodeIndex+1, rightBound);
        return head;
    }


    public static void main(String [] args) {

        int[] input = new int[]{1,2,3,4,5,6,7,8,9};
        TreeNode output = new MinimalTree().solution(input);
        System.out.println("Done");


    }




}
