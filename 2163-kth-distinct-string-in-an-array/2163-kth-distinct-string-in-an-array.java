import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Step 1: Count occurrences of each string
        Map<String, Integer> countMap = new LinkedHashMap<>(); // Preserve insertion order
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        
        // Step 2: Collect distinct strings that appear exactly once
        List<String> distinctStrings = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                distinctStrings.add(entry.getKey());
            }
        }
        
        // Step 3: Return the kth distinct string if it exists
        if (k > distinctStrings.size()) {
            return "";
        } else {
            return distinctStrings.get(k - 1);
        }
    }
}
