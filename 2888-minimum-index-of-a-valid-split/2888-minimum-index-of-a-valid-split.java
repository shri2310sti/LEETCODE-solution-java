import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        int totalFrequency = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalFrequency++;
            }
        }
        
        if (totalFrequency * 2 <= n) {
            return -1;
        }
        
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }
            int leftSize = i + 1;
            int rightSize = n - leftSize;
            
            if (leftCount * 2 > leftSize && (totalFrequency - leftCount) * 2 > rightSize) {
                return i;
            }
        }
        
        return -1; 
    }
}