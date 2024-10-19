class Solution {
    public char findKthBit(int n, int k) {
        // Base case: if n == 1, the string is "0" and only contains one bit
        if (n == 1) {
            return '0';
        }
        
        // Calculate the length of the current string S_n which is 2^n - 1
        int length = (1 << n) - 1;  // same as 2^n - 1
        
        // If k is exactly the middle element, return '1'
        if (k == length / 2 + 1) {
            return '1';
        }
        
        // If k is in the first half, it corresponds to S_{n-1}
        if (k < length / 2 + 1) {
            return findKthBit(n - 1, k);
        }
        
        // If k is in the second half, it corresponds to the reverse and inverted part of S_{n-1}
        // We need to find the mirrored position in S_{n-1} and invert the result
        int mirroredK = length - k + 1;
        char mirroredBit = findKthBit(n - 1, mirroredK);
        
        // Invert the bit (if it's '0', return '1', and vice versa)
        return mirroredBit == '0' ? '1' : '0';
    }
}
