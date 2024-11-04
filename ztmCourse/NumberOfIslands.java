package src.src.ztmCourse;

public class NumberOfIslands {
    public static void dfs(char[][] m,int i,int j)
    {
        if(i<0 || j<0 || i>=m.length || j>=m[0].length)
            return;
        if(m[i][j]!='1')
            return;
        m[i][j]='9';
        dfs(m,i-1,j);
        dfs(m,i,j+1);
        dfs(m,i+1,j);
        dfs(m,i,j-1);
    }
    public static int numIslands(char[][] grid)
    {
        int i,j,counter=0;
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    counter++;
                    dfs(grid,i,j);
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        char [][] grid = new char[3][3];
        grid[0] = new char[]{'1', '1', '0'};
        grid[1] = new char[]{'0', '1', '0'};
        grid[2] = new char[]{'0', '0', '0'};
        /*
        * [1, 1, 0, 0]
        * [0, 1, 0, 0]
        * [0, 1, 1, 0]
        * */
        System.out.println(numIslands(grid));
    }
}
