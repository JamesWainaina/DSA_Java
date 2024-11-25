/*91. Decode Ways
Solved
Medium
Topics
Companies
You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"

Output: 2


"12" could be decoded as "AB" (1 2) or "L" (12).
*/


class decodeWays {
    public int numDecodings(String s) {
        // base case 
        if (s == null || s.length() == 0){
            return 0;
        }

        // create a dp array to store the number of ways to decode a string
        int n = s.length();
        int[] dp = new int[n + 1];

        // there is a total of one way to decode a string of length 1
        dp[0] = 1;

        // if the 1st character is not a zero then there is a total of one way to decode it 
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        // iterate through the string and calculate the dp at i
        for (int i = 2; i <= n; i++){
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }

            // check for two letter combinations from 10 to 26
            int twoDigit = Integer.parseInt(s.substring(i - 2, i ));
            if (twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        decodeWays solution = new decodeWays();
        String s = "12";
        System.out.println(solution.numDecodings(s));
    }
}
