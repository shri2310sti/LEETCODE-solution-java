class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftEffect = new int[n + 1]; // Use an array to store the net effect of all shifts
        
        // Populate the shiftEffect array based on the shifts
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            shiftEffect[start] += (direction == 1) ? 1 : -1;
            shiftEffect[end + 1] += (direction == 1) ? -1 : 1;
        }
        
        // Compute the prefix sum to get the cumulative shift effect for each index
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += shiftEffect[i];
            shiftEffect[i] = currentShift;
        }
        
        // Apply the shiftEffect to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int shift = shiftEffect[i] % 26; // Wrap around within the alphabet range
            char newChar = (char) ((s.charAt(i) - 'a' + shift + 26) % 26 + 'a'); // Handle negative shifts
            result.append(newChar);
        }
        
        return result.toString();
    }
}
