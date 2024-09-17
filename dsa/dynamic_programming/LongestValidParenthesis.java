// 32. Longest Valid Parentheses
// Solved
// Hard
// Topics
// Companies
// Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
// substring
// .

 

// Example 1:

// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
// Example 2:

// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
// Example 3:

// Input: s = ""
// Output: 0
 

// Constraints:

// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.





public class LongestValidParenthesis {

    public static void main(String[] args) {
        testLongestValidParentheses("(()");

        // Test case 5: Mixed valid and invalid parentheses
        testLongestValidParentheses(")()())");

        // Test case 6: Longer string with valid parentheses
        testLongestValidParentheses("()(()))");
        
    }

    public static void testLongestValidParentheses(String s) {
        LongestValidParenthesis solution = new LongestValidParenthesis();
        int result = solution.longestValidParentheses(s);
        System.out.println("Input: \"" + s + "\", Longest valid parentheses length: " + result);
    }
    public int longestValidParentheses(String s) {

        int open = 0, close = 0, max = 0;

        for (char ch : s.toCharArray()){
            if (ch == '('){
                open++;
            }else {
                close++;
            }

            if (open == close){
                max = Math.max(open + close, max);
            }else if ( open > close){
                open = 0;
                close = 0;
            }
        }

        open = 0; close = 0;
        for (int i = s.length() -1; i>=0; i--){
            if (s.charAt(i) == ')'){
                close++;
            }else{
                open++;
            }

            if (open == close){
                max = Math.max(open + close, max);
            }else if( open > close){
                open = 0;
                close =0;
            }
        }
        return max;
    }
}
