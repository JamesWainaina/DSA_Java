import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class howSum {
	public static List<Integer> howSum(int targetSum, int[] numbers,HashMap<Integer, List<Integer>> memo) {
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		
		if (targetSum == 0) return new ArrayList<>();
		if (targetSum < 0 ) return null;
		for (int num : numbers) {
			int rem = targetSum - num;
			List<Integer> remainderResult = howSum(rem, numbers, memo);
			
			if (remainderResult != null) {
				remainderResult = new ArrayList<>(remainderResult);
				remainderResult.add(num);
				memo.put(targetSum, remainderResult);
				return remainderResult;
			}
		}
		memo.put(targetSum, null);
		return null;
	}
	public static void main(String[] args) {
		// Test case 1
        HashMap<Integer, List<Integer>> memo1 = new HashMap<>();
        System.out.println(howSum(7, new int[]{2, 3}, memo1));  // Output: [3, 2, 2] or another valid combination
        
        // Test case 2
        HashMap<Integer, List<Integer>> memo2 = new HashMap<>();
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}, memo2));  // Output: [7] or [4, 3]
        
        // Test case 3
        HashMap<Integer, List<Integer>> memo3 = new HashMap<>();
        System.out.println(howSum(300, new int[]{7, 14}, memo3));
	}
}
