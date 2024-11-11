import java.util.*;
/*
139. Word Break
Medium
Topics
Companies
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
*/

class wordBreak {
	 public boolean wordBreak(String s, List<String> wordDict) {
		Map<String, Boolean> memo = new HashMap<>();
		Set<String> wordSet = new HashSet<>(wordDict);
		return dfs(s, wordSet, memo);
	}
	public boolean dfs(String s, Set<String> wordSet, Map<String, Boolean> memo) {
		if (memo.containsKey(s)) return memo.get(s);
		if (wordSet.contains(s)) return true;
		for (int i = 1; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			if (wordSet.contains(prefix) && dfs(s.substring(i), wordSet, memo)){
				memo.put(s, true);
				return true;
			}
		}
		memo.put(s, false);
		return false;
	}
	public static void main(String[] args) {
		wordBreak solution = new wordBreak();
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		System.out.println(solution.wordBreak(s, wordDict));
	}
}
