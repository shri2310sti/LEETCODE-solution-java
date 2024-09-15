import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        // HashMap to store the first occurrence of a bitmask
        HashMap<Integer, Integer> seen = new HashMap<>();
        // Initialize the bitmask with 0 at index -1 to handle the full string case
        seen.put(0, -1);
        
        // Bitmask variable to track the count of vowels
        int bitmask = 0;
        int maxLength = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Update the bitmask for the current character if it is a vowel
            if (ch == 'a') {
                bitmask ^= 1 << 0; // Toggle bit for 'a'
            } else if (ch == 'e') {
                bitmask ^= 1 << 1; // Toggle bit for 'e'
            } else if (ch == 'i') {
                bitmask ^= 1 << 2; // Toggle bit for 'i'
            } else if (ch == 'o') {
                bitmask ^= 1 << 3; // Toggle bit for 'o'
            } else if (ch == 'u') {
                bitmask ^= 1 << 4; // Toggle bit for 'u'
            }

            // Check if the bitmask has been seen before
            if (seen.containsKey(bitmask)) {
                // Calculate the length of the substring
                maxLength = Math.max(maxLength, i - seen.get(bitmask));
            } else {
                // Store the first occurrence of the current bitmask
                seen.put(bitmask, i);
            }
        }

        return maxLength;
    }
}
