class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int mini = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            mini = Math.min(mini,prices[i]);
            profit = Math.max(profit, prices[i] - mini);
        }
        return profit;
    }
}