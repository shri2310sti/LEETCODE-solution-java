class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        // HashSets to track elements seen in A and B
        HashSet<Integer> seenA = new HashSet<>();
        HashSet<Integer> seenB = new HashSet<>();
        
        int commonCount = 0; // To count common elements at each index
        
        for (int i = 0; i < n; i++) {
            // Add current elements of A and B to their respective sets
            seenA.add(A[i]);
            seenB.add(B[i]);
            
            // If the element from A is in B's set, it's common
            if (seenB.contains(A[i])) {
                commonCount++;
            }
            // If the element from B is in A's set, it's common
            if (seenA.contains(B[i]) && A[i] != B[i]) {
                commonCount++;
            }
            
            // Update the result for the current index
            result[i] = commonCount;
        }
        
        return result;
    }
}
