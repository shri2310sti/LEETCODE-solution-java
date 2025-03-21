class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int v = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int mini = (int) v/3 + 1;

        for(int i = 0; i < v ; i++){
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value + 1);
            if(mpp.get(nums[i]) == mini) ans.add(nums[i]);
            if(ans.size() == 2) return ans;
        }
        return ans;
    }
}