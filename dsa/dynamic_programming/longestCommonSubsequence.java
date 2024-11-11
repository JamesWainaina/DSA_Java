/*
1143. Longest Common Subsequence
Solved
Medium
Topics
Companies
Hint
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

*/

public class longestCommonSubsequence {
	 public int longest(String text1, String text2) {
		// first take the lengths of the two strings
		int m = text1.length();
		int n = text2.length();
		
		// introduce dp for the two strings
		int[][] dp = new int[m + 1][n + 1];
		
		// iterate through the given strings comparing them to each other
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++) {
				//compare the strings
				if (text1.charAt(i - 1) == text2.charAt(j -1)) {
					dp[i][j] =  1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		// make an instance of the class
		longestCommonSubsequence solution = new longestCommonSubsequence();
		String text1 = "abcdef";
		String text2 = "acbef";
		System.out.println(solution.longest(text1, text2));
	}
}
