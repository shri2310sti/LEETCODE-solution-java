import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check further for this word
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] words1 = {"mass", "as", "hero", "superhero"};
        System.out.println(solution.stringMatching(words1)); // Output: ["as", "hero"]
        
        String[] words2 = {"leetcode", "et", "code"};
        System.out.println(solution.stringMatching(words2)); // Output: ["et", "code"]
        
        String[] words3 = {"blue", "green", "bu"};
        System.out.println(solution.stringMatching(words3)); // Output: []
    }
}
