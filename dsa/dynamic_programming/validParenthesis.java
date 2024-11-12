import java.util.*;
/*
20. Valid Parentheses
Solved
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
*/

class validParenthesis{
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		// iterate through the string
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '['){
				stack.push(ch);
			}else {
				if (ch == ')'){
					if (stack.isEmpty() || stack.pop() != '('){
						return false;
					}
				}
				if (ch == '}'){
					if (stack.isEmpty() || stack.pop() != '{') {
						return false;
					}
				}
				if (ch == ']'){
					if (stack.isEmpty() || stack.pop() != '['){
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args){
		validParenthesis solution = new validParenthesis();
		String s = "()";
		System.out.println(solution.isValid(s));
	}
}
