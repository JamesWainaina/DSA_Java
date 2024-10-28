import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class bestSum {
	public static List<Integer> bestSum(int targetSum, int[] numbers, HashMap<Integer, List<Integer>> memo) {
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		if (targetSum == 0) return new ArrayList<>();
		if (targetSum < 0) return null;
		List<Integer> shortestCombination = null;
		for (int num : numbers){
			int remainder = targetSum - num;
			List<Integer> remainderCombination = bestSum(remainder, numbers, memo);
			if (remainderCombination != null) {
				List<Integer> combination = new ArrayList<>(remainderCombination);
				combination.add(num);
			if (shortestCombination == null || combination.size() < shortestCombination.size()) {
				shortestCombination = combination;
			}
		}
	}
	memo.put(targetSum, shortestCombination);
	return shortestCombination;
	}
	public static void main(String[] args) {
        // Test case 1
        HashMap<Integer, List<Integer>> memo1 = new HashMap<>();
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}, memo1));  // Output: [7]

        // Test case 2
        HashMap<Integer, List<Integer>> memo2 = new HashMap<>();
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, memo2));  // Output: [25, 25, 25, 25]
    }
}
