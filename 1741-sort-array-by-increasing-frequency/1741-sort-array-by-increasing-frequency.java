import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Sort based on frequencies and values
        List<Integer> result = Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> {
                int freqA = frequencyMap.get(a);
                int freqB = frequencyMap.get(b);
                if (freqA != freqB) {
                    return freqA - freqB; // Sort by frequency
                } else {
                    return b - a; // Sort by value in decreasing order
                }
            })
            .collect(Collectors.toList());
        
        // Step 3: Convert the list back to an array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
