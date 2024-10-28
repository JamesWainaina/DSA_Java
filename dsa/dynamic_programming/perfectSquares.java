/*
279. Perfect Squares
Solved
Medium
Topics
Companies
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
*/

public class perfectSquares {
	public int numSquares(int n) {
		// use tabulation to create an array of size n + 1
		int[] dp = new int[n + 1];
		
		// fill the array with max_value
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		// there are zero ways of making perfect square of 0
		dp[0] = 0;
		
		// now we start filling the dp array with the values until we reach the end
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++ ){
				dp[i] = Math.min(dp[i] , dp[i - j*j] + 1);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// instance
		perfectSquares solution = new perfectSquares();
		int n = 12;
		System.out.println(solution.numSquares(n));
	}
}
