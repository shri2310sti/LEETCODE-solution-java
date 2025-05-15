import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<Integer>[] dp = new List[n];

        // Initialize each dp[i] with the word at index i
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(i);
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && dp[j].size() + 1 > dp[i].size()) {
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(i);
                }
            }
        }

        // Find the longest subsequence
        List<Integer> best = new ArrayList<>();
        for (List<Integer> seq : dp) {
            if (seq.size() > best.size()) {
                best = seq;
            }
        }

        // Build the result from indices
        List<String> result = new ArrayList<>();
        for (int idx : best) {
            result.add(words[idx]);
        }

        return result;
    }
}
