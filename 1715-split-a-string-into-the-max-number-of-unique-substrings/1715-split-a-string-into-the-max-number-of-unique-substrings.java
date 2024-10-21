import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int index, Set<String> uniqueSubstrings) {
        // Base case: If we've considered the entire string, return 0
        if (index == s.length()) {
            return 0;
        }

        int maxSplits = 0;

        // Try to split the string at every position starting from 'index'
        for (int i = index + 1; i <= s.length(); i++) {
            String currentSubstring = s.substring(index, i);

            // Only proceed if the current substring is unique
            if (!uniqueSubstrings.contains(currentSubstring)) {
                uniqueSubstrings.add(currentSubstring);
                
                // Recursively check the rest of the string
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, i, uniqueSubstrings));
                
                // Backtrack by removing the current substring from the set
                uniqueSubstrings.remove(currentSubstring);
            }
        }

        return maxSplits;
    }
}
