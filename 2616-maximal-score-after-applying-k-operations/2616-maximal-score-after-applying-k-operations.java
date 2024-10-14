import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        // Max-Heap to store the elements in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all elements of the array to the max-heap
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        long score = 0;
        
        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the largest element
            int largest = maxHeap.poll();
            // Add the largest element to the score
            score += largest;
            // Replace the largest element with ceil(largest / 3)
            int reduced = (largest + 2) / 3;
            // Add the reduced number back into the heap
            maxHeap.add(reduced);
        }
        
        return score;
    }
}
