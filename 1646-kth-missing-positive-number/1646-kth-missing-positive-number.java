class Solution {
    public int findKthPositive(int[] arr, int k) {
        // int i = 0;
        // int j = 1;

        // int n = arr.length;
        // int last = arr[n-1] + k;

        // int count = 0;

        // while(i < n && j <= last){
        //     if(arr[i] == j){
        //         i++;
        //         j++;
        //     } else {
        //         count++;
        //         if(count == k) return j;
        //         j++;
        //     }
        // }
        // while(j <= last){
        //     count++;
        //     if(count == k) return j;
        //     j++;
        // }
        // return -1;

        int n = arr.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
}