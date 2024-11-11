/* 516. Longest Palindromic Subsequence
Solved
Medium
Topics
Companies
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb"
*/

class longestPalindromicSubString{
	public int longestPalindromeSubseq(String s) {
		// take the length of the string s
		int n = s.length();
		int[][] dp = new int[n][n];

		// iterate through the string in reverse order
		for (int i = n - 1; i >= 0; i--) {
			// best case longest palindromic substring is of length one
			dp[i][i]= 1;
			for (int j = i + 1; j < n ; j++) {
				// compare the strings
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					// compare the max values for j and i
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j-1]);
				}
			}
		}
		// return the number at the right most of the dp array
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		longestPalindromicSubString solution = new longestPalindromicSubString();
		String s = "bbbab";
		System.out.println(solution.longestPalindromeSubseq(s));
	}
}
