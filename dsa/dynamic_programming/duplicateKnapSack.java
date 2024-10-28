/*
Given a set of N items, each with a weight and a value, represented by the array wt and val respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.
*/

public class duplicateKnapSack {
	static int knapSack(int N, int W, int val[], int wt[]){
	int[] dp = new int[W + 1];
	
	// fill the new array with zeros
	for (int i = 0; i <= W; i++){
		dp[i] = 0;
	}
	
	// iterate through all elements of the choosen element
	for (int i= 0; i < N; i++){
		for (int j = wt[i]; j <= W; j++) {
			dp[j] = Math.max(dp[j], dp[j - wt[i] + val[i]);
		}
	}
	return dp[W];
}

