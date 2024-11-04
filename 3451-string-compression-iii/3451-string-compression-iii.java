class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        
        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 0;
            
            // Count up to 9 occurrences of currentChar
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }
            
            // Append the count followed by the character to comp
            comp.append(count).append(currentChar);
        }
        
        return comp.toString();
    }
}
