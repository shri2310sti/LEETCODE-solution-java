class Solution {
    public int maximumSwap(int num) {
        // Convert number to character array for easy manipulation
        char[] digits = Integer.toString(num).toCharArray();
        
        // Array to store the last index of each digit (0-9)
        int[] last = new int[10];
        
        // Populate the last index of each digit
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }
        
        // Traverse through the number
        for (int i = 0; i < digits.length; i++) {
            // Check if a larger digit exists after the current digit
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap the current digit with the larger digit
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    
                    // Return the number after swapping
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap is made, return the original number
        return num;
    }
}
