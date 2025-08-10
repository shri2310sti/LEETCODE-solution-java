class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] count = countDigits(n);
        for (int i = 0; i < 31; i++) {
            if (matches(count, countDigits(1 << i))) return true;
        }
        return false;
    }

    private int[] countDigits(int num) {
        int[] res = new int[10];
        while (num > 0) {
            res[num % 10]++;
            num /= 10;
        }
        return res;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}