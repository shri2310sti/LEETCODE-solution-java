import java.util.Arrays;

class Solution {
    public int numTilings(int n) {
        final int MOD = 1000000007;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
            for (int j = 0; j <= i - 3; ++j) {
                dp[i] = (dp[i] + 2 * dp[j]) % MOD;
            }
        }

        return (int)dp[n];
    }
}