class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        
        // Case 1: Assume original[0] = 0
        if (isValid(derived, 0)) {
            return true;
        }
        
        // Case 2: Assume original[0] = 1
        if (isValid(derived, 1)) {
            return true;
        }
        
        return false;
    }
    
    private boolean isValid(int[] derived, int first) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = first;
        
        // Compute the original array based on derived
        for (int i = 1; i < n; i++) {
            original[i] = original[i - 1] ^ derived[i - 1];
        }
        
        // Check if derived[n-1] matches the circular XOR condition
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}
