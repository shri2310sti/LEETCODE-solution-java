class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums = new int [n];
        
        int i=0, j=0;
        int idx = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                nums[idx] = nums1[i];
                i++; idx++;
            }
            else{
                nums[idx] = nums2[j];
                j++; idx++;
            }
        }
        while(i<nums1.length){
            nums[idx] = nums1[i];
            i++; idx++;
        }
        while(j<nums2.length){
            nums[idx] = nums2[j];
            j++; idx++;
        }

        if(nums.length % 2 == 0){
            return (double) (nums[n/2] + nums[(n/2) - 1])/2;
        } else{
            return (double) nums[n/2];
        }
    }
}