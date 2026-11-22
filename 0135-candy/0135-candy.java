class Solution {
    public int candy(int[] r) {
        int ans = 0;
        int[] left = new int[r.length];

        left[0] = 1;
        for(int i=1; i<r.length; i++){
            if(r[i] > r[i-1]){
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }

        for(int i=r.length-2; i>=0; i--){
            if(r[i] > r[i+1]){
                left[i] = Math.max(left[i+1] + 1, left[i]);
            }
        }
        for(int i=0; i<r.length; i++) ans += left[i];
        return ans;
    }
}