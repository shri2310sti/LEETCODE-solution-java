class Solution {
    public boolean canChange(String start, String target) {
        // Remove blank spaces and check if the sequences of 'L' and 'R' match
        String filteredStart = start.replace("_", "");
        String filteredTarget = target.replace("_", "");
        if (!filteredStart.equals(filteredTarget)) {
            return false;
        }

        // Two pointers to traverse 'L' and 'R' positions in start and target
        int i = 0, j = 0, n = start.length();
        while (i < n && j < n) {
            // Skip blank spaces in both strings
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            // If both pointers are out of bounds, break the loop
            if (i == n && j == n) break;

            // If one pointer is out of bounds, the positions don't match
            if (i == n || j == n) return false;

            // Check movement constraints for 'L' and 'R'
            if (start.charAt(i) != target.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false; // 'L' can only move left
            if (start.charAt(i) == 'R' && i > j) return false; // 'R' can only move right

            // Move both pointers
            i++;
            j++;
        }

        return true;
    }
}
