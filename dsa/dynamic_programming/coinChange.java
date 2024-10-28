/*

Note
Note
Editorial
Editorial
Solutions
Solutions
Submissions
Code
[Java] Easy DP solution
[Java] Easy DP solution
Testcase
Testcase
Test Result
322. Coin Change
Solved
Medium
Topics
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

*/

public class coinChange {
	public int coinChange(int[] coins, int amount) {
		// check the base case first
		if (amount < 1 ) return 0;
	
		// create an array to store the amount
		int[] minCoinDp = new int[amount + 1];

		// fill the coins with max value
		for (int i = 1; i <= amount; i++){
			minCoinDp[i] = Integer.MAX_VALUE;
			// iterate throught the given coins
			for (coin : coins) {
				if (coin < i && minCoin[i - coin] != Integer.MAX_VALUE) {
					minCoinDp[i] = Math.min(minCoinDp[i], 1 + minCoinDp[i - 1]);
				}
			}
		}
		return minCoin[amount] == Integer.MAX_VALUE ? -1 : minCoin[amount];
	}
}	

	
