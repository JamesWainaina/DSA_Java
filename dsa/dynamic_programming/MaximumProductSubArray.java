// 152. Maximum Product Subarray
// Solved
// Medium
// Topics
// Companies
// Given an integer array nums, find a 
// subarray
//  that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any subarray of nums is guaranteed to fit in a 32-bit integer.



public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int sufix = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            // edge cases
            if (prefix == 0) prefix = 1;
            prefix *= nums[i];

            if (sufix == 0) sufix = 1;
            sufix *= nums[n - i - 1];
            ans = Math.max(ans, Math.max(prefix, sufix));
        }
        return ans;
    }
    
}
