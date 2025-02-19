import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, new StringBuilder(), ' ', happyStrings);
        
        // Check if k is within range
        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }

    private void backtrack(int n, StringBuilder current, char lastChar, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current.toString());
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (ch != lastChar) {  // Ensure it's a happy string
                current.append(ch);
                backtrack(n, current, ch, happyStrings);
                current.deleteCharAt(current.length() - 1);  // Backtrack
            }
        }
    }
}
