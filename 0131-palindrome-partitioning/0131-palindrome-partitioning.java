import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        backtrack(s, 0, partition, result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> partition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                partition.add(s.substring(start, end + 1));
                backtrack(s, end + 1, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
