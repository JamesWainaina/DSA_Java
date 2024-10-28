import java.util.HashMap;
import java.util.List;

public class canConstruct {
	public static boolean canConstruct(String target, List<String> wordBank, HashMap<String, Boolean> memo)  {
		if (memo.containsKey(target)) return memo.get(target);
		if (target.equals("")) return true;
		
		for (String word: wordBank){
			if (target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				if (canConstruct(suffix, wordBank, memo)) {
					memo.put(target, true);
					return true;
				}
			}
		}
		memo.put(target, false);
		return false;
	}
	public static void main(String[] args) {
		HashMap<String, Boolean> memo1 = new HashMap<>();
		System.out.println(canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), memo1));
		// Test case 2
        	HashMap<String, Boolean> memo2 = new HashMap<>();
        	System.out.println(canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"), memo2));  // Output: false

        // Test case 3 (a case that would take a long time without memoization)
        	HashMap<String, Boolean> memo3 = new HashMap<>();
        	System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", 
                        List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), memo3));  // Output: false
	}
} 
