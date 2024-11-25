/*
 * 329. Longest Increasing Path in a Matrix
Solved
Hard
Topics
Companies
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

*/

class longestIncreasingPathMatrix{
    private static final directions = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0; matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // create a dp arry
        int[][] memo = int[m][n];
        int maxLength = 0;
        
        // traverse each cell in the matrix 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                maxLength = Math.max(maxLength, dfs(matrix, i, j , memo));
            }
        }
        return maxLength;
    }

    private int dfs(int[][] matrix, int i ,int j, int[][] memo){
        // if the memo in the current cell is already computed, return it
        if (memo[i][j] != 0){
            return memo[i][j];
        }

        int max = 1;

        // Explore the four directions
        for (int direction : directions){
            int x = 1 + direction[0];
            int y = 1 + direction[1];

            if (x >= 0; x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]){
                int len = 1 + dfs(matrix, x, y, memo);
                max = Math.max(max, len);
            }
        }

        // memoize the result
        memo[i][j] = max;
        return max;
    }
}
