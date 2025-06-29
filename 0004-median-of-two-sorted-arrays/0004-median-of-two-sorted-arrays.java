class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        ArrayList<Integer> arr = new ArrayList<>();

        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                arr.add(nums1[i]);
                i++;
            } else {
                arr.add(nums2[j]);
                j++;
            }
        }
        while(i < n1){
            arr.add(nums1[i]);
            i++;
        }
        while(j < n2){
            arr.add(nums2[j]);
            j++;
        }

        if(n % 2 == 1) return arr.get(n/2);
        return (double)((double)(arr.get(n/2) + arr.get(n/2 - 1)))/2.0;
    }
}