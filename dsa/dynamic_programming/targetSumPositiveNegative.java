// 494. Target Sum
// Solved
// Medium
// Topics
// Companies
// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

class targetSumPositiveNegative {
	public int findTargetSumWays(int[] nums, int target){
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		// base case conditions
		if (((sum - target) % 2 == 1) || (target > sum)) {
			return 0;
		}
		
		int n = nums.length;
		int s2 = (sum - target) / 2;
		
		// Dynamic Programming
		int[][] t = new int[n + 1][s2 + 1];
		t[0][0] = 1;
		
		for (int i = 1; i <= n; i++){
			for (int j = 0; j <= s2; j++) {
				if (nums[i - 1] <= j) {
					t[i][j] = t[i - 1][j] + t[i-1][j - nums[i-1]];
				}else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][s2];	
	
	}
	public static void main(String[] args){
		targetSumPositiveNegative targetSum = new targetSumPositiveNegative();
		int[] nums1 = {1, 1, 1, 1, 1};
		 int target = 3;
		System.out.println("Test Case 1: Expected Output = 5, Actual Output = " + targetSum.findTargetSumWays(nums1, target));
	}

}	
