import java.util.*;
/*
22. Generate Parentheses
Solved
Medium
Topics
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/

class generateParenthesis{
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		dfs(0, 0, "", n, res);
		
		return res;
	}
	private void dfs(int openP, int closeP, String s, int n, List<String> res) {
		if (openP == closeP && openP + closeP == n * 2){
			res.add(s);
			return;
		}
		if (openP < n){
			dfs(openP + 1, closeP, s + "(",n ,res);
		}
		if (closeP < n) {
			dfs(openP, closeP + 1, s + ")", n, res);
		}
	}
	public static void main(String[] args) {
		generateParenthesis solution = new generateParenthesis();
		int n = 3;
		System.out.println(solution.generateParenthesis(n));
	}
}
