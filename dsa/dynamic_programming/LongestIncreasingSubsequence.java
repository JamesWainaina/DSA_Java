/*
300. Longest Increasing Subsequence
Solved
Medium
Topics
Companies
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.
*/

class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int longestInc = 0;
		
		// do binary search on the 
		for (int current : nums) {
			int i = 0, j = longestInc;
			int mid = (i + j ) / 2;
			while (i != j) {
				if(dp[mid] < current){
					i = mid + 1;
				} else {
					j = mid;
				}
			}
			dp[i] = current;
			if (i == longestInc) longestInc++;
		}
		return longestInc;	
	}
	public static void main(String[] args) {
		int nums = {10,9,2,5,3,7,101,18};
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		System.out.println(solution.lengthOfLIS(nums));
	}
}
