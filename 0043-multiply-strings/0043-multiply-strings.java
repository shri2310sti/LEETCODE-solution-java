class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        // Iterate through num1 and num2 to calculate multiplication
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }

        // Construct the result string
        StringBuilder res = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros
            if (!(res.length() == 0 && num == 0)) {
                res.append(num);
            }
        }

        // If the result string is empty, return "0"; otherwise, return the result string
        return res.length() == 0 ? "0" : res.toString();
    }
}
