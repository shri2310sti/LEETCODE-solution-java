class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;  // Start with the first number lexicographically.
        k--;  // We consider the first number, so decrement k by 1.
        
        while (k > 0) {
            int count = countNumbersInRange(current, n);
            if (count <= k) {
                // If the numbers under the current prefix are less than or equal to k,
                // skip them and move to the next prefix.
                current++;
                k -= count;
            } else {
                // If the kth number is under this prefix, go deeper.
                current *= 10;
                k--;
            }
        }
        
        return current;
    }
    
    // Helper function to count numbers under a given prefix.
    private int countNumbersInRange(long prefix, int n) {
        long current = prefix;
        long next = prefix + 1;
        int count = 0;
        
        while (current <= n) {
            count += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        
        return count;
    }
}
