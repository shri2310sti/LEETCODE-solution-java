class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int down = dp[i + 1][j];

                int diagonalLeft = Integer.MAX_VALUE;
                if(j > 0) diagonalLeft = dp[i + 1][j - 1];

                int diagonalRight = dp[i + 1][j + 1];

                int pathSum = Math.min(
                    down,
                    Math.min(diagonalLeft, diagonalRight)
                );

                dp[i][j] = pathSum == Integer.MAX_VALUE
                    ? pathSum
                    : matrix[i][j] + pathSum;
            }
        }

        int minimum = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++) {
            minimum = Math.min(minimum, dp[0][j]);
        }

        return minimum;
    }
}