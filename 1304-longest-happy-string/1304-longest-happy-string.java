class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        
        // Array to store counts of characters and their respective identifiers
        int[][] counts = new int[][]{{a, 'a'}, {b, 'b'}, {c, 'c'}};
        
        while (true) {
            // Sort counts by the remaining count in descending order
            Arrays.sort(counts, (x, y) -> y[0] - x[0]);
            
            // Try to add the most frequent character
            if (counts[0][0] == 0) {
                break; // No more characters left to add
            }
            
            int len = result.length();
            // Check if we can add the most frequent character
            if (len >= 2 && result.charAt(len - 1) == counts[0][1] && result.charAt(len - 2) == counts[0][1]) {
                // If adding it would form a bad string, try the second most frequent character
                if (counts[1][0] == 0) {
                    break; // No more characters left to add without violating the rules
                }
                // Add second most frequent character
                result.append((char) counts[1][1]);
                counts[1][0]--; // Decrease its count
            } else {
                // Otherwise, add the most frequent character
                result.append((char) counts[0][1]);
                counts[0][0]--; // Decrease its count
            }
        }
        
        return result.toString();
    }
}
