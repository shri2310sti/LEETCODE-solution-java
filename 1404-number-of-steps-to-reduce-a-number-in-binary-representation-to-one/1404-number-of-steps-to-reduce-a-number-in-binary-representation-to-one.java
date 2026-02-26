class Solution {
    public int numSteps(String s) {
        int steps = 0;
        // We are working with the string, converting it to a char array for easier manipulation
        StringBuilder sb = new StringBuilder(s);
        
        // Continue until the string represents the number "1"
        while (!sb.toString().equals("1")) {
            if (sb.charAt(sb.length() - 1) == '0') {
                // If the last character is '0', it's even, divide by 2 (remove the last character)
                sb.setLength(sb.length() - 1);
            } else {
                // If the last character is '1', it's odd, we need to add 1
                // This might create a carry, so we need to handle the addition correctly
                int i = sb.length() - 1;
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                if (i >= 0) {
                    sb.setCharAt(i, '1');
                } else {
                    // If we overflow beyond the most significant bit, we need to add '1' at the start
                    sb.insert(0, '1');
                }
            }
            // Increment the step counter for each operation
            steps++;
        }
        
        return steps;
    }
}