class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        // Iterate through the input string
        for (int i = 0; i < s.length(); i++) {
            // If we already have two of the same characters at the end of result, skip adding the current character
            if (result.length() >= 2 &&
                result.charAt(result.length() - 1) == s.charAt(i) &&
                result.charAt(result.length() - 2) == s.charAt(i)) {
                continue;
            }
            // Otherwise, add the character to result
            result.append(s.charAt(i));
        }
        
        // Convert StringBuilder to String and return
        return result.toString();
    }
}