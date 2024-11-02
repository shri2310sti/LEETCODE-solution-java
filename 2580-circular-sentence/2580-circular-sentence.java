class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Check the circular conditions
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            String nextWord = words[(i + 1) % words.length]; // Circular check
            
            // Last character of current word and first character of next word
            if (currentWord.charAt(currentWord.length() - 1) != nextWord.charAt(0)) {
                return false;
            }
        }
        
        // All checks passed, the sentence is circular
        return true;
    }
}
