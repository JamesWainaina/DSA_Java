import java.util.HashMap;
import java.util.List;

public class countConstruct {
	public static int countConstruct(String target, List<String> wordBank, HashMap<String, Integer> memo) {
		if (memo.containsKey(target)) return memo.get(target);
		if (target.equals("")) return 1;
		int total = 0;
		for (String word : wordBank) {
			if (target.indexOf(word) == 0) {

				String suffix = target.substring(word.length());
				int numWaysSuffix = countConstruct(suffix, wordBank, memo);
				total += numWaysSuffix;
			}
		}
	memo.put(target, total);
	return total;
	}
	public static void main(String[] args) {
        	// Test case 1
        	HashMap<String, Integer> memo1 = new HashMap<>();
        	System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), memo1));  // Output: 1

        	// Test case 2
        	HashMap<String, Integer> memo2 = new HashMap<>();
        	System.out.println(countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"), memo2));  // Output: 0

        	// Test case 3 (a case that would take a long time without memoization)
        	HashMap<String, Integer> memo3 = new HashMap<>();
        	System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", 
                	List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), memo3));  // Output: 0
    }
}
