class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        // If the length is odd, it can never be valid
        if (n % 2 != 0) {
            return false;
        }
        
        // Left-to-right pass
        int open = 0, flexible = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    open++;
                } else {
                    open--;
                }
            } else {
                flexible++;
            }
            // If there are too many closing brackets, return false
            if (open + flexible < 0) {
                return false;
            }
        }
        
        // Right-to-left pass
        open = 0;
        flexible = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    open++;
                } else {
                    open--;
                }
            } else {
                flexible++;
            }
            // If there are too many opening brackets, return false
            if (open + flexible < 0) {
                return false;
            }
        }
        
        return true;
    }
}
