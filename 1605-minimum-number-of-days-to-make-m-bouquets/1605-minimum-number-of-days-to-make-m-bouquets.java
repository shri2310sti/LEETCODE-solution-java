class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            if(max < bloomDay[i]) max = bloomDay[i];
            if(min > bloomDay[i]) min = bloomDay[i];
        }

        if(bloomDay.length < m*k) return -1;


        // //Linear Search
        // for(int i = min; i <= max; i++){
        //     if(possible(bloomDay, i, m, k)) return i;
        // }

        // //Binary Search
        int low = min, high = max;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    static boolean possible(int[] bloomday, int day, int m, int k){
        int count = 0;
        int noOfBouquet = 0;
        for(int i = 0; i < bloomday.length; i++){
            if(bloomday[i] <= day){
                count++;
            }else{
                noOfBouquet += (count / k);
                count = 0;

            }
        }
        noOfBouquet += (count / k);
        if(noOfBouquet >= m) return true;
        else return false;
    }
}