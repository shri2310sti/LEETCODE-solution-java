class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1_000_000_007;
        int m = words[0].length(); // Length of each word
        int n = target.length();  // Length of the target

        // Step 1: Precompute the frequency of each character at each position
        int[][] freq = new int[m][26]; // freq[i][c] stores the count of character 'c' in column i
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }

        // Step 2: Dynamic Programming
        long[][] dp = new long[m + 1][n + 1];
        // Base case: There is exactly one way to form an empty target (j = 0)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) { // Iterate through columns in words
            for (int j = 1; j <= n; j++) { // Iterate through characters in target
                // Option 1: Don't use column i to form target[j-1]
                dp[i][j] = dp[i - 1][j];

                // Option 2: Use column i to form target[j-1], if possible
                char targetChar = target.charAt(j - 1);
                int charFreq = freq[i - 1][targetChar - 'a'];
                if (charFreq > 0) {
                    dp[i][j] += dp[i - 1][j - 1] * charFreq;
                    dp[i][j] %= MOD;
                }
            }
        }

        // The answer is in dp[m][n]
        return (int) dp[m][n];
    }
}
