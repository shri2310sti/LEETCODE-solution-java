class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR of start and goal will give bits where they differ
        int xor = start ^ goal;
        
        // Count the number of 1s in the xor result (Hamming weight)
        int count = 0;
        while (xor > 0) {
            // Increment count for every 1 bit found
            count += xor & 1;
            // Right shift xor to check the next bit
            xor >>= 1;
        }
        
        return count;
    }
}
