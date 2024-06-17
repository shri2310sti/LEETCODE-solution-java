class Solution {
    public int[] plusOne(int[] digits) {
      int n = digits.length;

        // Start from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit by 1
            digits[i]++;
            // If the digit is less than 10, no carry, return the digits array
            if (digits[i] < 10) {
                return digits;
            }
            // If the digit is 10, set it to 0 and continue to the next digit
            digits[i] = 0;
        }
        
        // If we reach here, all digits were 9, so we need to add an extra digit
        int[] result = new int[n + 1];
        result[0] = 1; // Carry over 1
        return result;  
    }
}