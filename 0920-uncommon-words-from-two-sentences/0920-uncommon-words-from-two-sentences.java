import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Combine both sentences into one
        String combined = s1 + " " + s2;
        
        // Split the combined string into words
        String[] words = combined.split(" ");
        
        // Use a HashMap to count occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect words that appear exactly once
        List<String> uncommonWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }
        
        // Return the result as an array
        return uncommonWords.toArray(new String[0]);
    }
}
