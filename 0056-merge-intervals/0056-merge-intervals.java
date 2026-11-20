class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0; i<n; i++) arr.add(intervals[i]);
        Collections.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i)[1] >= arr.get(i+1)[0]){
                if(arr.get(i)[0] > arr.get(i+1)[0]) arr.get(i)[0] = arr.get(i+1)[0];
                if(arr.get(i)[1] < arr.get(i+1)[1]) arr.get(i)[1] = arr.get(i+1)[1];
                arr.remove(i+1);
                i--;
            }
            
        }
        return arr.toArray(new int[arr.size()][]);
    }
}