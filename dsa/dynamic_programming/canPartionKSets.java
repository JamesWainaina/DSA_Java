import java.util.Arrays;
/*
698. Partition to K Equal Sum Subsets
Solved
Medium
Topics
Companies
Hint
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
*/
class canPartionKSets {
	public boolean canPartitionKSubsets(int[] nums, int k){
		int sum = 0;
		for (int num : nums){
			sum += num;
		}
		//if sum is not divisible by k return false
		if (sum % k != 0){
			return false;
		}

		// target value
		int target = sum / k;
		
		// keep track of the visited nums
		boolean[] used = new boolean[nums.length];
		// sort the Array
		Arrays.sort(nums);
		
		// check if the largest element is larger than target return false
		if (nums[nums.length - 1] > target) {
			return false;
		}
		//start backtracking
		return backtrack(nums, used, k, target, 0, 0);
	}
	private boolean backtrack(int[] nums, boolean[] used, int k, int target, int currentSum, int start){
		if (k == 1) {
			return true;
		}
		// if currentSum equals target move on to the next subset
		if (currentSum == target){
			return backtrack(nums, used, k-1, target, 0, 0);
		}
		for (int i = start; i < nums.length; i++) {
			// if current element is already used skip it 
			if (used[i]) {
				continue;
			}
			// if adding the currrent element exceeds the target sum skip it
			if (currentSum + nums[i] > target) {
				continue;
			}
			used[i] = true;
			if (backtrack(nums, used, k, target, currentSum + nums[i], i + 1)){
				return true;
			}
			used[i] = false;
		}
		return false;
	}
	public static void main(String[] args) {
		canPartionKSets solution = new canPartionKSets();
		int[] nums= {4,3,2,3,5,2,1}; 
		int k = 4;
		System.out.println(solution.canPartitionKSubsets(nums, k));
	}
}
