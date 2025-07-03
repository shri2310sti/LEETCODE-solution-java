class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            if(maxPile < piles[i]) maxPile = piles[i];
        }
        // for(int i = 1; i <= maxPile; i++){
        //     if(func(piles, i) <= h) return i;
        // }
        
        int low = 1, high = maxPile;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(func(piles, mid) <= h){
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }
    static int func(int[] piles, int bananaperhr){
        int ans = 0;
        for(int i = 0; i < piles.length; i++){
            ans += Math.ceil((double)piles[i]/(double)bananaperhr);
        }
        return ans;
    }
}