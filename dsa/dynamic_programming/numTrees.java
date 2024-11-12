/*
96. Unique Binary Search Trees
Solved
Medium
Topics
Companies
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
*/

class numTrees {
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1; // since there is one way to make trees of one and two trees
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++){
				dp[i] += dp[j -1] * dp[i - j];
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n = 3;
		numTrees solution = new numTrees();
		System.out.println(solution.numTrees(n));
	}
}
