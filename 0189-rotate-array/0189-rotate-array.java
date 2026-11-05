class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // int c = 0;
        // while(c<k){
        //     int temp = nums[nums.length-1];
        //     for(int i = nums.length-1; i>0; i--){
        //         nums[i] = nums[i-1];
        //     }
        //     nums[0] = temp;
        //     c++;
        // }
        

        // int i = 0, j = nums.length-1;
        // while(i<j){
        //     int temp = nums[i];
        //     nums[i] = nums[j];
        //     nums[j] = temp;
        //     i++;
        //     j--;
        // } // 7 6 5 4 3 2 1

        // int o = 0, l = k-1;
        // while(o<l){
        //     int temp = nums[o];
        //     nums[o] = nums[l];
        //     nums[l] = temp;
        //     o++;
        //     l--;
        // } //5 6 7 4 3 2 1

        // int m = k, n = nums.length-1;
        // while(m<n){
        //     int temp = nums[m];
        //     nums[m] = nums[n];
        //     nums[n] = temp;
        //     m++;
        //     n--;
        // } //5 6 7 1 2 3 4

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int nums[], int s, int e){
        while(s<e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}