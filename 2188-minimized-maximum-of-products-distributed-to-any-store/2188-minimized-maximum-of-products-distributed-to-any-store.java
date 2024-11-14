class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = getMax(quantities);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid; // Try to minimize x further
            } else {
                left = mid + 1; // Increase x
            }
        }
        
        return left;
    }
    
    // Helper function to get the maximum value in the quantities array
    private int getMax(int[] quantities) {
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        return max;
    }
    
    // Helper function to determine if we can distribute with max x per store
    private boolean canDistribute(int[] quantities, int n, int x) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            requiredStores += (quantity + x - 1) / x; // Equivalent to Math.ceil(quantity / x)
            if (requiredStores > n) return false; // Early exit if more stores are needed
        }
        return requiredStores <= n;
    }
}
