class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0; // to track the maximum element encountered so far
        int chunks = 0; // to count the number of chunks
        
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]); // update the maximum element
            // If the maximum element so far equals the current index, we can form a chunk
            if (max == i) {
                chunks++;
            }
        }
        
        return chunks;
    }
}
