class Solution {
    public long coloredCells(int n) {
        return 1L + 2L * (long)n * (n - 1);
    }
}
