class Solution {
    public int findKthPositive(int[] arr, int k) {
        int last = arr[arr.length - 1] + k;
        int count = 0;
        int i = 0, j = 1;
        while(i < arr.length && j < last){
            
            if(arr[i] == j){
                i++;
                j++;
            } else{
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