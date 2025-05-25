class Solution {
    public int longestPalindrome(String[] words) {
        // Create a map to store the frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();
        // Loop through the array of words to populate the map with word counts
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Initialize variables to store the length of palindrome formed and a flag for center character allowance
        int palindromeLength = 0, singleCenter = 0;

        // Iterate over the map entries to calculate the maximum possible palindrome length
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            String reversedWord = new StringBuilder(word).reverse().toString();
            int count = entry.getValue();

            // If the word is the same as its reversed version and has two identical characters,
            // it can potentially be a center of the palindrome
            if (word.charAt(0) == word.charAt(1)) {
                // Check if there's an odd count, if so one instance can be used as a center
                singleCenter += count % 2;
                // Add the even part into the palindrome length (doubled, as palindromes are symmetric)
                palindromeLength += (count / 2) * 2 * 2;
            } else {
                // If the word is not its own reversed, pair it with its reverse occurrence count
                palindromeLength += Math.min(count, wordCount.getOrDefault(reversedWord, 0)) * 2;
            }
        }

        // If there is at least one single center word, add 2 to the length for the center character of palindrome
        palindromeLength += singleCenter > 0 ? 2 : 0;

        // Return the total calculated palindrome length
        return palindromeLength;
    }
}