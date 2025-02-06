import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int count = 0;
        
        // Iterate through all pairs (i, j)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                
                // If product exists in map, add 8 * previous count to total count
                if (productCount.containsKey(product)) {
                    count += 8 * productCount.get(product);
                }
                
                // Store/update the product in the map
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }
        
        return count;
    }
}
