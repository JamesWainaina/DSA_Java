import java.util.*;


/*
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

 

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/

class maxEnvelopes {
	  public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if (n == 0) return 0;
		
		// sort the array either by height or weight
		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] == b[0]) return a[1] - b[1]; // sort by height
			return a[0] - b[0]; // otherwise sort by weight 
		});
		
		// find the longest increasing subsequence based on height
		List<Integer> lis = new ArrayList<>();	
		for (int[] envelope: envelopes) {
			int height = envelope[1];
			
			// binary search to find the positon to either replace it or extend it
			int idx = Collections.binarySearch(lis, height);
			if (idx < 0 ) idx = -(idx + 1);
			
			// if the height is greater than all the other heights append it to the lis
			if (idx == lis.size()) {
				lis.add(height);
			} else {
				// otherwise replace the current height for optimization
				lis.set(idx, height);
			}
		}
		return lis.size();
	}
	public static void main(String[] args) {
		int[][] nums = {{5,4},{6,4},{6,7},{2,3}};
		maxEnvelopes solution = new maxEnvelopes();
		System.out.println(solution.maxEnvelopes(nums));
	}
}
