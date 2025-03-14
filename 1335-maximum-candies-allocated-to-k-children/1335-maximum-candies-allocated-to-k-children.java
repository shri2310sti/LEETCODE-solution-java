class Solution {
    public int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        int maxCandy = 0;
        
        for (int c : candies) {
            totalCandies += c;
            maxCandy = Math.max(maxCandy, c);
        }
        
        if (totalCandies < k) return 0; 
        
        int left = 1, right = maxCandy;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canDistribute(candies, k, mid)) {
                result = mid;
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        
        return result;
    }
    
    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0;
        
        for (int c : candies) {
            count += c / mid;
            if (count >= k) return true; 
        }
        
        return false;
    }
}
