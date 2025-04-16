import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        long count = 0;  // Number of pairs
        long result = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            int f = freq.getOrDefault(val, 0);
            count += f;  
            freq.put(val, f + 1);

            while (count >= k) {
                result += n - right; 
                int removeVal = nums[left];
                int removeFreq = freq.get(removeVal);
                count -= (removeFreq - 1);  
                if (removeFreq == 1) freq.remove(removeVal);
                else freq.put(removeVal, removeFreq - 1);
                left++;
            }
        }

        return result;
    }
}
