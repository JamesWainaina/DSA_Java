/*
518. Coin Change II
Solved
Medium
Topics
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
*/

public class coinChange2 {
	public int change(int amount, int[] coins) {
		// handle edge cases
		if (amount == 0) return 1;
		
		if (coins == null || coins.length == 0 ) return 0;
		
		// create an array of the size of amount + 1
		int[] dp = new int[amount + 1];
		
		// initiate the first value to be 1 since
		// there is only one way to make a chane of zero
		dp[0] = 1;		
		// itereate through the given coins
		for (int coin : coins) {
			// iterate though the table to find the ways of making change
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
	public static void main(String[] args) {
		coinChange2 solution = new coinChange2();
		int[] coins = { 1, 2, 5 };
		int amount = 5;
		System.out.println(solution.change(amount, coins));
	}	
}	
