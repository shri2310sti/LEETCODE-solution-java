import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Create a set of banned integers for quick lookup
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        
        int count = 0; // Number of integers selected
        int currentSum = 0; // Cumulative sum of selected integers
        
        // Iterate through the range [1, n]
        for (int i = 1; i <= n; i++) {
            // Check if the number is banned or if adding it exceeds maxSum
            if (!bannedSet.contains(i) && currentSum + i <= maxSum) {
                currentSum += i; // Add the number to the sum
                count++; // Increment the count of selected numbers
            }
        }
        
        return count;
    }
}
