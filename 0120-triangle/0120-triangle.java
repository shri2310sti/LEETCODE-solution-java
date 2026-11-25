class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];
        for(int i=0; i<triangle.size(); i++){
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return helper(triangle,0,0,dp);
    }
    int helper(List<List<Integer>> triangle, int n, int m, int[][] dp){
        if(n==triangle.size()-1) return triangle.get(n).get(m);
        if(dp[n][m] != Integer.MAX_VALUE) return dp[n][m];
        int p1 = triangle.get(n).get(m) + helper(triangle,n+1, m,dp);
        int p2 = triangle.get(n).get(m) + helper(triangle,n+1, m+1,dp);
        return dp[n][m] = Math.min(p1,p2);
    }
}