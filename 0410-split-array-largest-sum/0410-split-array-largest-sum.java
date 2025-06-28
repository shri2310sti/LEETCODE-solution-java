class Solution {
    public int splitArray(int[] nums, int k) {

        if(nums.length < k) return -1;

        int low = Integer.MIN_VALUE; //largest element
        int high = 0; // sum
        for(int i = 0; i < nums.length; i++){
            high += nums[i];
            if(nums[i] > low) low = nums[i];
        }

        // Linear Search
        // for(int i = low; i <= high; i++){
        //     if(func(nums, i) == k) return i;
        // }
        // return low;

        //Binary Search
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(func(nums, mid) <= k) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    static int func(int[] nums, int maxSum){
        int cnt = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] <= maxSum) sum += nums[i];
            else {
                cnt++;
                sum = nums[i];
            }
        }
        return cnt;
    }
}