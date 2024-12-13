import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;
        boolean[] marked = new boolean[n];
        
        // Create a priority queue to store {value, index}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // If values are equal, compare indices
            }
            return a[0] - b[0]; // Otherwise, compare values
        });
        
        // Add all elements to the priority queue
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            // If the current element is already marked, skip it
            if (marked[index]) continue;

            // Add the value to the score
            score += value;

            // Mark the current element and its adjacent elements
            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < n - 1) marked[index + 1] = true;
        }

        return score;
    }
}
