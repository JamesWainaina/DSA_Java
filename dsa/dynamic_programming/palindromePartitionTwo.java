/*
132. Palindrome Partitioning II
Solved
Hard
Topics
Companies
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: 
*/

class palindromePartitionTwo {
	public int minCut(String s) {
		int n = s.length();
		// base case 
		if (n <= 1) return 0;
		
		// create a palindrome table
		boolean[][] palindrome = new boolean[n][n];
		// first make every character to be a palindrome
		for (int i = 0; i < n; i++){
			palindrome[i][i] = true;
		}
		// check for two letter palindromes
		for (int i = 0; i < n-1; i++) {
			palindrome[i][i+1] = (s.charAt(i) == s.charAt(i + 1));
		}
		// check for three letter combinations or more 
		for (int len = 3; len <= n; len++){
			for (int i = 0; i < n - len + 1; i++){
				int j = i + len - 1;
				palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j -1]);
			}
		}

		// create a dp table to store the minimum cuts
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			// if the word from 0 to i is a palindrome no cuts should be made
			if (palindrome[0][i]) {
				dp[i] = 0;
			} else{
				dp[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++){
					if (palindrome[j + 1][i]){
						dp[i] = Math.min(dp[i], dp[j] + 1);
					}
				}
			}
		}
		return dp[n -1];
	}
	public static void main(String[] args) {
		palindromePartitionTwo solution = new palindromePartitionTwo();
		String s = "aab";
		System.out.println(solution.minCut(s));
	}
}	
