class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        int i = 0, j = 0;
        int n1 = words1.length, n2 = words2.length;
        
        // Start matching words from the beginning
        while (i < n1 && i < n2 && words1[i].equals(words2[i])) {
            i++;
        }
        
        // Start matching words from the end
        while (j < n1 - i && j < n2 - i && words1[n1 - 1 - j].equals(words2[n2 - 1 - j])) {
            j++;
        }
        
        // If the sum of the matched prefix and suffix equals the length of the shorter sentence, they are similar
        return i + j == Math.min(n1, n2);
    }
}
