import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max-heap to store piles of gifts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all the gift piles to the heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Simulate the process for k seconds
        while (k > 0 && !maxHeap.isEmpty()) {
            int largestPile = maxHeap.poll(); // Get the largest pile
            int remainingGifts = (int) Math.floor(Math.sqrt(largestPile)); // Calculate gifts left behind
            maxHeap.add(remainingGifts); // Put the remaining gifts back into the heap
            k--;
        }

        // Calculate the total number of remaining gifts
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }

        return totalGifts;
    }
}