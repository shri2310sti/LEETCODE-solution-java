class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;  // Single character needs one turn
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1;  // Default case: print s[j] separately
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + (k + 1 <= j - 1 ? dp[k + 1][j - 1] : 0));
                    }
                }
            }
        }

        return dp[0][n - 1];  // The entire string's minimum turns
    }
}
