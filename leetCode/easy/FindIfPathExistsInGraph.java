package src.src.leetCode.easy;

public class FindIfPathExistsInGraph {
    /*
    *  There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
    *  The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
    *  Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
    *  You want to determine if there is a valid path that exists from vertex source to vertex destination.
    *  Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
    */

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int accessedVertices = 0;
        boolean sourceFound = false;
        boolean destinationFound = false;

        for(int i = 0; i < edges.length; i++){



        }



        return true;
    }

    public static void main(String[] args) {
        // Input
        int n = 3;
        int[][] edges = new int[][]{
                {0,1},
                {1,2},
                {2,0}};
        int source = 0;
        int destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }
}
