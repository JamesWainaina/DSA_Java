/*

Note
Note
Editorial
Editorial
Solutions
Solutions
Submissions
Code
Testcase
Testcase
Test Result
1312. Minimum Insertion Steps to Make a String Palindrome
Solved
Hard
Topics
Companies
Hint
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.
*/

class minimumInsertionsPalindrome{
	public int minInsertions(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = 0 ; i < n; i++) {
			dp[i][i] = 1;
		}
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j -1]);
				}
			}
		}
		int lsp = dp[0][n-1];
		return n - lsp;
	}
	public static void main(String[] args) {
		minimumInsertionsPalindrome solution = new minimumInsertionsPalindrome();
		String s = "zzazz";
		System.out.println(solution.minInsertions(s));
	}
}	
