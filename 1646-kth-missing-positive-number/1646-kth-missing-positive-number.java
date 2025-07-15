class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int j = 1;

        int n = arr.length;
        int last = arr[n-1] + k;

        int count = 0;

        while(i < n && j <= last){
            if(arr[i] == j){
                i++;
                j++;
            } else {
                count++;
                if(count == k) return j;
                j++;
            }
        }
        while(j <= last){
            count++;
            if(count == k) return j;
            j++;
        }
        return -1;
    }
}