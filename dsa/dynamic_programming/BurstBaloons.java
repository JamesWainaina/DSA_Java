/*
 *
 * 312. Burst Balloons
Solved
Hard
Topics
Companies
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

*/

class BurstBaloons {
    public int maxCoins(int[] nums) {
           int n = nums.length;

           // create  a new array to add size at the end and start 
           int[] newNums = new int[n + 2];
           newNums[0] = 1;
           newNums[n + 1] = 1;
           
           // fill the new array with the nums 
           for (int i = 1; i <= n; i++){
               newNums[i] = nums[i - 1];
           }

           // create a new dp array to calcualate the max coins
           int[][] dp = new int[n + 2][n + 2];
           for (int length = 2; length <= n + 1; length++){
               for (int left = 0; left + length <= n + 1; left++){
                   int right = left + length;

                   // try bursting the baloons from left to right starting from i
                   for (int i = left + 1; i < right; i++){
                       dp[left][right] = Math.max(dp[left][right], dp[left][i] + dp[i][right]  + newNums[left] * newNums[i] * newNums[right]);
                   }
               }
           }
           return dp[0][n + 1];
     }
     public static void main(String[] args){
         BurstBaloons solution = new BurstBaloons();
         int[] nums = {3,1,5,8};
         System.out.println(solution.maxCoins(nums));
     }
}
