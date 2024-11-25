/*
 * 64. Minimum Path Sum
Solved
Medium
Topics
Companies
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

class minimumPathSumGrid{
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        // create a dp table
        int[][] dp = new int[m][n];

        // starting point to travers the grid
        //
        dp[0][0] = grid[0][0];
        // we can only go to the right 
        for (int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // we can only go to the left
        for (int i = 1; i< m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // fill the dp array
        for (int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] + Math.max(dp[i-1][j], dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
         



