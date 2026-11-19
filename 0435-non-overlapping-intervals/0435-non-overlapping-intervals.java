class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int c = 0;
        int last = Integer.MIN_VALUE;
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][0] >= last){
                last = intervals[i][1];
                c++;
            }
        }
        return intervals.length-c;
    }
}