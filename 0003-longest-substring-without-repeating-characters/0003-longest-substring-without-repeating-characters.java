class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Initialize variables
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;
        
        // Iterate through the string
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            // If the character is already in the map and its index is after the start of the current substring,
            // update the start index to the next position of the repeated character
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }
            // Update the index of the current character in the map
            charIndexMap.put(currentChar, end);
            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}