import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort items by price
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        
        // Prepare an array to store maximum beauty up to each price
        int[] maxBeauties = new int[items.length];
        maxBeauties[0] = items[0][1];
        
        // Fill maxBeauties with the highest beauty seen up to each item
        for (int i = 1; i < items.length; i++) {
            maxBeauties[i] = Math.max(maxBeauties[i - 1], items[i][1]);
        }
        
        // Step 2: Sort queries and remember original indexes
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        
        int[] result = new int[queries.length];
        int j = 0;
        
        // Step 3: Process each query
        for (int[] query : sortedQueries) {
            int priceLimit = query[0];
            int originalIndex = query[1];
            
            // Step 4: Find the rightmost item with price <= priceLimit
            while (j < items.length && items[j][0] <= priceLimit) {
                j++;
            }
            
            // If we found valid items, use the max beauty up to the last valid item
            result[originalIndex] = (j == 0) ? 0 : maxBeauties[j - 1];
        }
        
        return result;
    }
}
