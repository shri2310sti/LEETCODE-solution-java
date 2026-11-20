class Solution {
    public int minGroups(int[][] intervals) {
        int[] left = new int[intervals.length];
        int[] right = new int[intervals.length];

        for(int i=0; i<intervals.length; i++){
            left[i] = intervals[i][0];
            right[i] = intervals[i][1];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int c = 0;
        int i = 0, j = 0;
        int max = 0;
        while(i<intervals.length){
            if(left[i] <= right[j]){
                i++;
                c++;
            } else {
                j++;
                c--;
            }
            max = Math.max(c, max);
        }
        return max;
    }
}