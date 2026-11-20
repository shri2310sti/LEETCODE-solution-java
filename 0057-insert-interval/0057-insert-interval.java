class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        // ArrayList<int[]> arr = new ArrayList<>();
        // for(int i=0; i<n; i++) arr.add(intervals[i]);
        // arr.add(newInterval);

        // Collections.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        
        // for(int i=0; i<arr.size()-1; i++){
        //     if(arr.get(i)[1] >= arr.get(i+1)[0]){
        //         if(arr.get(i)[0] > arr.get(i+1)[0]) arr.get(i)[0] = arr.get(i+1)[0];
        //         if(arr.get(i)[1] < arr.get(i+1)[1]) arr.get(i)[1] = arr.get(i+1)[1];
        //         arr.remove(i+1);
        //         i--;
        //     }
            
        // }
        // return arr.toArray(new int[arr.size()][]);

        int i=0;
        ArrayList<int[]> arr = new ArrayList<>();
        while(i<n && intervals[i][1] < newInterval[0]) {
            arr.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]); 
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]); 
            i++;
        }
        arr.add(newInterval);

        while(i<n){
            arr.add(intervals[i]);
            i++;
        }
        return arr.toArray(new int[arr.size()][]);
    }
}