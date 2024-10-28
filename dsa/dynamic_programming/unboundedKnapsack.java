import java.util.*;

public class unboundedKnapsack {
	static int ukRec(int W, int[] wt, int[] val, int idx, int[][] memo) {
		// base case 
		if (idx == 0) {
			return (W/wt[0]) * val[0];
		}

		// if the value is already calculated, return the previous value
		if (memo[idx][W] != -1){
			return memo[idx][W];
		}
		// either take the element or not
		int notTake = ukRec(W, wt, val, idx-1, memo);
		// if you take the element then weight = W-wt[idx]  and i'ndex will remain the same
		int take = Integer.MIN_VALUE;
		if (wt[idx] <= W) {
			take = val[idx] + ukRec(W - wt[idx], wt, val, idx, memo);
		}
		return memo[idx][W] = Math.max(take, notTake);
	}
	// Wrapper method for unbounded knapsack
	static int uks(int W, int[] wt, int[] val) {
		int n = val.length;
		int[][] memo = new int[n][W + 1];
		
		for (int i = 0; i < n; i++){
			Arrays.fill(memo[i], -1);
		}
		return ukRec(W, wt, val, n-1, memo);
	}
	
	public static void main(String[] args) {
		int W = 100;
		int[] val = {10, 30, 20};
		int[] wt = {5, 10, 15};
		System.out.println(uks(W, wt, val));
	}
}
