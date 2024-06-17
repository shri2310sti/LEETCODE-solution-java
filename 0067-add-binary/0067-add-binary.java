class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0; // Initialize carry to 0
        
        // Traverse both strings from right to left
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            // Get the current digits of a and b
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;
            
            // Calculate the sum of current digits and carry
            int sum = digitA + digitB + carry;
            // Update carry for the next iteration
            carry = sum / 2;
            // Append the remainder to the result
            sb.append(sum % 2);
            
            // Move to the next digits in both strings
            i--;
            j--;
        }
        
        // If there's a remaining carry, append it to the result
        if (carry > 0) {
            sb.append(carry);
        }
        
        // Reverse the result to get the correct order
        return sb.reverse().toString();
    }
}
