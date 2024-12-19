// 22. Generate Parentheses
// Medium
// Topics
// Companies
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Time Complexity:The time complexity is roughly𝑂(4𝑛/𝑛)O(4 n/n ​)
// because at each step there are multiple choices,but not all lead to
// valid strings,so the complexity is related to the number of 
// Catalan numbers(which count valid parentheses combinations).
 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]

import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {

    public static void main(String[] args) {
        testGenerateParenthesis(0);

        // Test case 2: n = 1
        testGenerateParenthesis(1);

        // Test case 3: n = 2
        testGenerateParenthesis(2);

    }

    // function to test generateParenthesis
    public static void testGenerateParenthesis(int n){
        GenerateParenthesis pg = new GenerateParenthesis();
        List<String> res = pg.generateParenthesis(n);
        System.out.println("n = " + n + ":" + res);
    }

     public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(0, 0,"", n, res);

        return res;
     }

     private void dfs( int openP, int closeP, String s, int n, List<String> res){
        if (openP == closeP && openP + closeP == 2 * n){
            res.add(s);
            return;
        }
        // check if we can add open parenthesis

        if (openP < n){
            dfs(openP + 1, closeP, s + "(", n, res);
        }

        // check if we can add close parenthesis
        if (closeP < openP){
            dfs(openP, closeP + 1,  s + ")", n, res);
        }
     }
}
