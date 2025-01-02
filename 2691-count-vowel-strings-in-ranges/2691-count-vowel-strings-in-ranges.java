class Solution {
    // Function to determine the number of words with a starting and ending vowel in given queries.
    public int[] vowelStrings(String[] words, int[][] queries) {
        // Set containing all the vowels for easy reference.
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
      
        // The number of words in the input array.
        int wordCount = words.length;
      
        // An array to store the cumulative count of words that start and end with a vowel.
        int[] cumulativeVowelCount = new int[wordCount + 1];
      
        // Loop through each word to populate the `cumulativeVowelCount` array.
        for (int i = 0; i < wordCount; ++i) {
            char firstChar = words[i].charAt(0); // First character of the current word.
            char lastChar = words[i].charAt(words[i].length() - 1); // Last character of the current word.

            // Update the cumulative count. Increment if both first and last chars are vowels.
            cumulativeVowelCount[i + 1] = cumulativeVowelCount[i] + (vowels.contains(firstChar) && vowels.contains(lastChar) ? 1 : 0);
        }
      
        // The number of queries to process.
        int queryCount = queries.length;
        // Array to hold the answers to each query.
        int[] answer = new int[queryCount];
      
        // Process each query to get the number of words that start and end with a vowel.
        for (int i = 0; i < queryCount; ++i) {
            int leftIndex = queries[i][0], rightIndex = queries[i][1]; // Extracting the range from the query.
          
            // Answer for this query is the difference in the cumulative counts.
            answer[i] = cumulativeVowelCount[rightIndex + 1] - cumulativeVowelCount[leftIndex];
        }
      
        // Return the array containing the answer to each query.
        return answer;
    }
}