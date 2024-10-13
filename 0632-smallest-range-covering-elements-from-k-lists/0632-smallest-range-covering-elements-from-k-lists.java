import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Priority queue (min-heap), to store elements of the form (value, list index, element index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int currentMax = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        
        // Initialize the heap with the first element from each list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new int[] { value, i, 0 });
            currentMax = Math.max(currentMax, value);  // Update the current maximum
        }
        
        // Now process the heap until we run out of elements in one of the lists
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();
            int value = current[0], listIndex = current[1], elementIndex = current[2];
            
            // Check if the current range is smaller than the best found so far
            if (currentMax - value < rangeEnd - rangeStart) {
                rangeStart = value;
                rangeEnd = currentMax;
            }
            
            // If there is a next element in the same list, add it to the heap
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[] { nextValue, listIndex, elementIndex + 1 });
                currentMax = Math.max(currentMax, nextValue);  // Update the current maximum
            } else {
                // If we've exhausted one list, we can't find a valid range anymore
                break;
            }
        }
        
        return new int[] { rangeStart, rangeEnd };
    }
}
