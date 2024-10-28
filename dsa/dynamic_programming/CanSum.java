import java.util.HashMap;

public class CanSum {
	public static boolean canSum(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		if (targetSum == 0) return true;
		if (targetSum < 0) return false;
		for (int num : numbers) {
			int rem = targetSum - num;
			if (canSum(rem, numbers, memo)){
				memo.put(targetSum, true);
				return true;
			}
		}
		memo.put(targetSum, false);
		return false;
	}
	public static void main(String[] args) {
		HashMap<Integer, Boolean> memo1 = new HashMap<>();
		System.out.println(canSum(7, new int[] {2, 3, 4}, memo1));
		HashMap<Integer, Boolean> memo2 = new HashMap<>();
		System.out.println(canSum(300, new int[]{7, 14}, memo2));
	}
}
