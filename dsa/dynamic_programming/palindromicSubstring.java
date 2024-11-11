/*
647. Palindromic Substrings
Solved
Medium
Topics
Companies
Hint
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
*/

class palindromicSubstring {
	public int countSubstrings(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int count = 0;
		
		//iterate through the string in reverse order 
		for (int i = n-1; i >=0; i--){
			for (int j = i; j < n; j++) {
				// first check the characters are a match
				if (s.charAt(i) == s.charAt(j)){
					// check the length of the string
					if (j - i <= 2) {
						dp[i][j] = true;
					}else {
						dp[i][j] = dp[i + 1][j -1];
					}
				}
				if (dp[i][j]){
					count ++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args){
		palindromicSubstring solution = new palindromicSubstring();
		String s = "abc";
		System.out.println(solution.countSubstrings(s));
	}
}

