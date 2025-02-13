class Solution {
    // Method to calculate the minimum number of operations to reach numbers >= k.
    public int minOperations(int[] nums, int k) {
        // Create a priority queue to store the elements in non-decreasing order.
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        // Add all numbers from the given array to the priority queue.
        for (int num : nums) {
            priorityQueue.offer((long) num);
        }
        // Initialize a counter to keep track of the number of operations performed.
        int operationsCount = 0;
        // Process the elements in the priority queue while there are more than 
        // one element and the smallest element is less than k.
        while (priorityQueue.size() > 1 && priorityQueue.peek() < k) {
            // Increment the operations counter.
            operationsCount++;
            // Pop the two smallest elements from the priority queue.
            long first = priorityQueue.poll();
            long second = priorityQueue.poll();
            // Combine the elements as per given in the problem requirement:
            // Replace them with min * 2 + max and add back to priority queue.
            priorityQueue.offer(Math.min(first, second) * 2 + Math.max(first, second));
        }
        // Return the final count of operations or -1 if the requirement is not met.
        return priorityQueue.peek() >= k ? operationsCount : -1;
    }
}