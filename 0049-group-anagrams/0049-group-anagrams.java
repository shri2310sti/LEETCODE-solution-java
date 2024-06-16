import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        // Initialize a map to store groups of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort the characters of the string to create a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // Add the original string to the corresponding group in the map
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        
        // Convert the map values to a list of lists and return
        return new ArrayList<>(map.values());
    }
}
