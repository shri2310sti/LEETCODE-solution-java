class Solution {
    // TrieNode class to represent each node in the Trie
    class TrieNode {
        TrieNode[] children;  // To store references to child nodes
        int count;            // Count of words that have the prefix ending at this node
        
        // Constructor for TrieNode
        public TrieNode() {
            children = new TrieNode[26]; // One child for each letter 'a' to 'z'
            count = 0;                   // Initially, count is zero
        }
    }
    
    // Method to insert a word into the Trie
    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Calculate index for character 'a' to 'z'
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // Create new node if doesn't exist
            }
            current = current.children[index];  // Move to the next node
            current.count++;  // Increment the count at this node
        }
    }
    
    // Method to get the sum of prefix scores for a given word
    private int getPrefixScore(TrieNode root, String word) {
        TrieNode current = root;
        int score = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            current = current.children[index];
            score += current.count;  // Add the count of the current prefix
        }
        return score;
    }
    
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();  // Create a root node for the Trie
        
        // Insert all words into the Trie
        for (String word : words) {
            insert(root, word);
        }
        
        int[] result = new int[words.length];  // Array to store the result
        
        // Calculate the prefix scores for each word
        for (int i = 0; i < words.length; i++) {
            result[i] = getPrefixScore(root, words[i]);
        }
        
        return result;  // Return the result array
    }
}
