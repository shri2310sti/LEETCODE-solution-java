class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return func(n);
    }
    public int func(int n){
        if(n == 0 || n == 1) return 1;
        int dp0 = 1;
        int dp1 = 2;
        for(int i=2; i<n; i++){
            int curr = dp0 + dp1;
            dp0 = dp1;
            dp1 = curr;
        }
        
        return dp1;
    }
}