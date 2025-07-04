class Solution {
    public int findKthPositive(int[] arr, int k) {
        // int last = arr[arr.length - 1] + k;
        // int count = 0;
        // int i = 0, j = 1;
        // while(i < arr.length && j < last){
            
        //     if(arr[i] == j){
        //         i++;
        //         j++;
        //     } else{
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


        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;

        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] <= k) k++; //shifting k
        //     else break;
        // }
        // return k;
    }
}