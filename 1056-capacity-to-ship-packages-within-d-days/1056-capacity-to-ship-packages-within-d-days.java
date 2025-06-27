class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            if(max < weights[i]) max = weights[i];
            sum += weights[i];
        }

        // Linear Search
        // for(int i = max; i <= sum; i++){
        //     int reqDays= days(weights, i);
        //     if(reqDays <= days) return i;
        // }

        //Bianry Search
        int low = max, high = sum;
        int ans = 0;
        
        while(low <= high){
            int mid = (low + high) / 2;
            int noOfDays = days(weights, mid);
            if(noOfDays > days){
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return low;
    }
    static int days(int[] weights, int capacity){
        int day = 1;
        int load = 0;

        for(int i = 0; i < weights.length; i++){
            if((load + weights[i]) > capacity){
                day++;
                load = weights[i];
            } else load += weights[i];

        }
        return day;
    }

}