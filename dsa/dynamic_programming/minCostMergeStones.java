/*
 * 1000. Minimum Cost to Merge Stones
Solved
Hard
Topics
Companies
There are n piles of stones arranged in a row. The ith pile has stones[i] stones.

A move consists of merging exactly k consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these k piles.

Return the minimum cost to merge all piles of stones into one pile. If it is impossible, return -1.

*/

class minCostMergeStones {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;

        // check if it is possible to merge the stones in k steps
        if ((n - 1) % (k - 1) != 0){
            return -1;
        }

        // prefix sum to compute the sum of stones in range
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // create a dp array to compute the min cost to merge stones
        int[][] dp = new int[n][n];
        for (int length = k; length <= n; length++){
            for (int i = 0; i + length <= n; i++){
                int j = length + i - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // merge the subproblems from i to j
                for (int m = i; m < j; m += k - 1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }

                // check if it is possible to merge from i to j 
                if ((j - i) % (k -1) == 0){
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args){
        minCostMergeStones solution = new minCostMergeStones();
        int[] stone = {3,2,4,1};
        int k = 2;
        System.out.println(solution.mergeStones(stone, k));
    }
}
