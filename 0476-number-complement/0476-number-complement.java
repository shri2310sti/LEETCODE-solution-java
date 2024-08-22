class Solution {
    public int findComplement(int num) {
        // Step 1: Find the number of bits in num
        int bitLength = Integer.toBinaryString(num).length();
        
        // Step 2: Create a bitmask with the same length as num
        int bitmask = (1 << bitLength) - 1;
        
        // Step 3: XOR num with the bitmask to get the complement
        return num ^ bitmask;
    }
}
