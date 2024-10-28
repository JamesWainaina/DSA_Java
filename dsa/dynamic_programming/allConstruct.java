import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class allConstruct {

    // Method to return all ways to construct the target from wordBank
    public static List<List<String>> allConstruct(String target, List<String> wordBank, HashMap<String, List<List<String>>> memo) {
        // Check if the result is memoized
        if (memo.containsKey(target)) return memo.get(target);
        
        // Base case: If target is an empty string, return a list containing an empty list (1 way to construct it)
        if (target.equals("")) {
            List<List<String>> baseCase = new ArrayList<>();
            baseCase.add(new ArrayList<>());
            return baseCase;
        }

        List<List<String>> result = new ArrayList<>();

        // Loop through each word in the wordBank
        for (String word : wordBank) {
            // If target starts with the word
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());  // Get the suffix after the word
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);  // Get all ways to construct the suffix

                // Add the current word to each way of constructing the suffix
                List<List<String>> targetWays = new ArrayList<>();
                for (List<String> way : suffixWays) {
                    List<String> newWay = new ArrayList<>(way);
                    newWay.add(0, word);  // Prepend the current word to the way
                    targetWays.add(newWay);
                }

                // Add all targetWays to the result
                result.addAll(targetWays);
            }
        }

        // Memoize the result
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        HashMap<String, List<List<String>>> memo1 = new HashMap<>();
        System.out.println(allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), memo1));

        // Test case 2
        HashMap<String, List<List<String>>> memo2 = new HashMap<>();
        System.out.println(allConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"), memo2));

        // Test case 3 (a case that would take a long time without memoization)
        HashMap<String, List<List<String>>> memo3 = new HashMap<>();
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", 
                List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), memo3));
    }
}

