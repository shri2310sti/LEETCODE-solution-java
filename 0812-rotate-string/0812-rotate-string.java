class Solution {
    public boolean rotateString(String s, String goal) {
        // Step 1: Check if lengths are different; if so, return false
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Step 2: Concatenate s with itself
        String doubled = s + s;
        
        // Step 3: Check if goal is a substring of doubled
        return doubled.contains(goal);
    }
}
