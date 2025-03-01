class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxP = 0;
        for(int i = 0; i<prices.length; i++){
            int cost = prices[i] - mini;
            maxP = Math.max(maxP, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxP;
    }
}
