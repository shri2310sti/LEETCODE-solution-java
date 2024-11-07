class Solution {
    public int largestCombination(int[] candidates) {
        int maxCount = 0;

        // We only need to check up to the 24th bit position (0 to 23) since 10^7 fits within 24 bits.
        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            
            // Count how many numbers have a 1 in the current bit position.
            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            
            // Update maxCount if this bit position has a higher count of 1s.
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
