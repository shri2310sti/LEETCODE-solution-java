class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Track the minimum price
        int maxProfit = 0; // Track maximum profit
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update minPrice if a lower price is found
            } 
            maxProfit = Math.max(maxProfit, prices[i] - minPrice); // Check if selling today gives max profit
        }
        
        return maxProfit;
    }
}
