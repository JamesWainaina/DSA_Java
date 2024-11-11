/*
583. Delete Operation for Two Strings
Solved
Medium
Topics
Companies
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
*/

class deleteOperations {
	public int minDistance(String word1, String word2) {
		// the intuition behind this problem is to find the 
		// longest common subsequence and subtract it from the original string.
		int longCommon = longestCommonSubsequence(word1, word2);
		int rem = (word1.length() - longCommon + word2.length() - longCommon); 

		return rem; 
		
	}
	
	public int longestCommonSubsequence(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new intp[m + 1][n + 1];
		
		// iterate through the two strings
		for (int i = 1; i <= m; i++ ){
			for (int j = 1; j <= n; j++) {
				// compare the strings 
				if (word1.charAt(i - 1) == word2.charAt(j - 1) {
					dp[i][j] = 1 + dp[i -1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1];
				}
			}
		}
		return dp[m][n];
	}
}
	
		
		
