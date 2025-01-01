class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int totalOnes = 0; // Count of all '1's in the string
        int maxScore = Integer.MIN_VALUE;
        
        // Count total ones in the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }
        
        int leftZeros = 0; // Count of zeros in the left substring
        int rightOnes = totalOnes; // Remaining ones for the right substring
        
        // Iterate through the string to calculate scores
        for (int i = 0; i < n - 1; i++) { // Exclude the last position to ensure two non-empty substrings
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            
            int currentScore = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, currentScore);
        }
        
        return maxScore;
    }
}
