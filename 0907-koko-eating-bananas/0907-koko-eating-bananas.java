class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            if(maxPile < piles[i]) maxPile = piles[i];
        }

        
        // for(int i = 1; i <= maxPile; i++){
        //     int RequiredTime = totalTime(piles,i);
        //     if(RequiredTime <= h) return i; 
        // }

        int low = 1, high = maxPile;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;
            int RequiredTime = totalTime(piles, mid);
            if(RequiredTime <= h) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
            else low = mid + 1;


        }
        return ans;
    }
    public int totalTime(int[] arr, int hourly){
        int totalhrs = 0;
        for(int i = 0; i < arr.length; i++){
            totalhrs += Math.ceil((double)(arr[i]) / (double)(hourly));
        }
        return totalhrs;
    }
}