import java.util.*;
/*
472. Concatenated Words
Solved
Hard
Topics
Companies
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.

 

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
*/

class findAllConcateWords{
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Set<String> wordSet = new HashSet<>(Arrays.asList(words));
		List<String> result = new ArrayList<>();
		
		for(String word : words) {
			wordSet.remove(word); // remove the current word from being used
			if (canform(word, wordSet)) {
				result.add(word);
			}
			wordSet.add(word);
		}
		return result;
	}
	
	public boolean canform(String word, Set<String> wordSet) {
		int n = word.length();
		// base case
		if (n == 0) return false;

		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		//check each prefix of the word
		for (int i = 1; i <= n; i++){
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordSet.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		findAllConcateWords solution = new findAllConcateWords();
		String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		System.out.println(solution.findAllConcatenatedWordsInADict(words));
	}
}	
