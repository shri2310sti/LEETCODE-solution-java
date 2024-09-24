class Solution {
    // Define the TrieNode class
    class TrieNode {
        TrieNode[] children = new TrieNode[10];  // For digits 0-9
    }

    // Insert a number as a string into the Trie
    private void insert(TrieNode root, String number) {
        TrieNode node = root;
        for (char ch : number.toCharArray()) {
            int index = ch - '0';  // Convert char '0'-'9' to index 0-9
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
    }

    // Find the longest common prefix between the number and the Trie
    private int findLongestPrefix(TrieNode root, String number) {
        TrieNode node = root;
        int prefixLength = 0;
        for (char ch : number.toCharArray()) {
            int index = ch - '0';
            if (node.children[index] != null) {
                prefixLength++;  // If matching, extend the prefix
                node = node.children[index];
            } else {
                break;  // Stop when no further match
            }
        }
        return prefixLength;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Step 1: Create a root for the Trie
        TrieNode root = new TrieNode();

        // Step 2: Insert all numbers from arr1 into the Trie
        for (int num : arr1) {
            insert(root, String.valueOf(num));  // Convert num to string and insert
        }

        // Step 3: Find the longest common prefix between arr2 elements and the Trie
        int maxPrefixLength = 0;
        for (int num : arr2) {
            int prefixLength = findLongestPrefix(root, String.valueOf(num));
            maxPrefixLength = Math.max(maxPrefixLength, prefixLength);
        }

        // Step 4: Return the maximum prefix length found
        return maxPrefixLength;
    }
}
