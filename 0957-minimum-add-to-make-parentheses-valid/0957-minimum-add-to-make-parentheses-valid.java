class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;  // Count of unmatched opening '('
        int closeCount = 0; // Count of unmatched closing ')'
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++; // Add to open parenthesis count
            } else { // c == ')'
                if (openCount > 0) {
                    openCount--; // Match the open parenthesis with this closing parenthesis
                } else {
                    closeCount++; // No opening to match this closing, so we need an extra opening parenthesis
                }
            }
        }
        
        // Total moves = unmatched opening parentheses + unmatched closing parentheses
        return openCount + closeCount;
    }
}
