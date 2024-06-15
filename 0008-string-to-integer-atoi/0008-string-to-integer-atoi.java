class Solution {
    public int myAtoi(String s) {
         // Remove leading whitespace
        s = s.trim();
        
        if (s.isEmpty())
            return 0;
        
        // Initialize variables
        int sign = 1;
        int i = 0;
        int result = 0;
        
        // Check for sign
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            i++;
        }
        
        // Convert characters to integer until a non-digit character is found
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}