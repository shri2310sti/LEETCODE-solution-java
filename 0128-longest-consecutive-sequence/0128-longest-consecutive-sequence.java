class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> mp = new HashSet<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++) mp.add(nums[i]);

        for(int i : mp){
            if(!mp.contains(i-1)){
                int start = i;
                int c = 1;
                while(mp.contains(start+1)){
                    c++;
                    start++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }
}