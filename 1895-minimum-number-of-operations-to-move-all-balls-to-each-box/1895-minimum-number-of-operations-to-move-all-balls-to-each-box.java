class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int count = 0; // Count of balls encountered
        int operations = 0; // Cumulative operations
        
        // Left-to-right pass
        for (int i = 0; i < n; i++) {
            answer[i] += operations;
            count += boxes.charAt(i) - '0'; // Update ball count
            operations += count; // Update cumulative operations
        }
        
        count = 0;
        operations = 0;
        
        // Right-to-left pass
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            count += boxes.charAt(i) - '0'; // Update ball count
            operations += count; // Update cumulative operations
        }
        
        return answer;
    }
}
