import java.util.Map;
import java.util.HashMap;

/**
 * climbingStairs
 * 70. Climbing Stairs
 * Attempted
 * Easy
 * Topics
 * Companies
 * Hint
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 45
 */
public class climbingStairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }
    private int climbStairs(int n, Map<Integer, Integer> memo){
        if (n== 0 || n == 1){
            return 1;
        }

        if (!memo.containsKey(n)){
            memo.put(n, climbStairs(n -1, memo) + climbStairs(n-1, memo));
        }
        return memo.get(n);
    }
}