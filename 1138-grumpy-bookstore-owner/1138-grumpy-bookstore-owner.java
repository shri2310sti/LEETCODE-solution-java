class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        
        // Calculate the initially satisfied customers (where grumpy is 0)
        int totalSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        
        // Find the best window to apply the non-grumpy technique
        int maxAdditionalSatisfied = 0;
        int currentWindowAdditionalSatisfied = 0;
        
        // Initial window calculation
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentWindowAdditionalSatisfied += customers[i];
            }
        }
        maxAdditionalSatisfied = currentWindowAdditionalSatisfied;
        
        // Slide the window
        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                currentWindowAdditionalSatisfied -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                currentWindowAdditionalSatisfied += customers[i];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentWindowAdditionalSatisfied);
        }
        
        return totalSatisfied + maxAdditionalSatisfied;
    }
}
