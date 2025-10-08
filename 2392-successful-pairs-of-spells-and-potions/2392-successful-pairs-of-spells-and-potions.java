import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        
        // Sort the potions array
        Arrays.sort(potions);
        
        // For each spell, find the number of successful pairs using binary search
        for (int i = 0; i < n; i++) {
            long requiredPotionStrength = (success + spells[i] - 1) / spells[i]; // Equivalent to ceil(success / spells[i])
            int idx = binarySearch(potions, requiredPotionStrength);
            result[i] = m - idx;
        }
        
        return result;
    }
    
    private int binarySearch(int[] potions, long required) {
        int left = 0;
        int right = potions.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < required) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

}