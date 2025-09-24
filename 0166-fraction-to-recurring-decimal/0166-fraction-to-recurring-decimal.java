class Solution {

    /**
     * Converts a fraction (given by numerator and denominator) into its decimal string representation.
     * It handles both terminating and repeating decimals.
     * @param numerator The top part of the fraction.
     * @param denominator The bottom part of the fraction.
     * @return The decimal representation as a String.
     */
    public String fractionToDecimal(int numerator, int denominator) {
        // --- Step 1: Handle the simple case where the numerator is 0 ---
        // If the numerator is 0, the fraction is just 0, so we return "0".
        if (numerator == 0) return "0";
        
        // --- Step 2: Prepare for building the result string ---
        // `result` will be a StringBuilder, which is efficient for building strings piece by piece.
        StringBuilder result = new StringBuilder();
        
        // `remainderPositions`: This is our "notepad" for detecting repeating remainders.
        // Key: A remainder value (Long, to handle potential large values).
        // Value: The position (index) in the `result` string where this remainder was first encountered.
        Map<Long, Integer> remainderPositions = new HashMap<>();
        
        // --- Step 3: Determine and append the sign ---
        // Check if the numerator and denominator have different signs.
        // The XOR operator `^` is true if one is negative and the other is not.
        // This checks if the final result should be negative.
        if ((numerator < 0) ^ (denominator < 0)) {
            // If the signs are different, append a "-" sign to the result.
            result.append("-");
        }
        
        // --- Step 4: Work with absolute values and calculate the integer part ---
        // Convert numerator and denominator to absolute `long` values.
        // We use `long` to avoid potential overflow issues if the numerator or denominator are `Integer.MIN_VALUE`
        // when taking the absolute value (abs(Integer.MIN_VALUE) is larger than Integer.MAX_VALUE).
        long num = Math.abs((long) numerator); // Absolute value of numerator.
        long den = Math.abs((long) denominator); // Absolute value of denominator.
        
        // Calculate the integer part of the division (e.g., 7 / 3 = 2).
        result.append(num / den);
        // Calculate the remainder (e.g., 7 % 3 = 1). This is what we'll use for the fractional part.
        long remainder = num % den;
        
        // --- Step 5: Handle the case where the division is exact (no fractional part) ---
        // If the remainder is 0, the division was exact (e.g., 4/2 = 2).
        if (remainder == 0) {
            // We just return the result string built so far (which only contains the integer part).
            return result.toString();
        } else {
            // --- Step 6: Handle the fractional part and detect repeating decimals ---
            // If there's a remainder, we need to append a decimal point.
            result.append(".");
        
            // Now, we enter a loop to calculate the fractional digits.
            // We continue as long as the remainder is not 0 (meaning there's still a fractional part to calculate).
            while (remainder != 0) {
                // --- Step 6a: Check for repeating remainders ---
                // Before doing any calculations, check if we've seen this `remainder` before.
                // `remainderPositions.containsKey(remainder)` checks our "notepad".
                if (remainderPositions.containsKey(remainder)) {
                    // If we HAVE seen this remainder before:
                    // 1. Get the position (`pos`) in the `result` string where this remainder was first seen.
                    int pos = remainderPositions.get(remainder);
                    // 2. Insert an opening parenthesis '(' at that `pos`.
                    result.insert(pos, "(");
                    // 3. Append a closing parenthesis ')' at the end of our current `result` string.
                    result.append(")");
                    // 4. We've found the repeating part, so we break out of the loop.
                    break;
                }

                // --- Step 6b: Record the current remainder and its position ---
                // If we haven't seen this remainder before, record it in our "notepad".
                // The key is the `remainder` itself, and the value is the current length of our `result` string
                // (which is the position where the *next* digit will be appended).
                remainderPositions.put(remainder, result.length());
            
                // --- Step 6c: Calculate the next fractional digit ---
                // To get the next digit, we "bring down a zero" by multiplying the remainder by 10.
                // Then, we divide this new value by the denominator to get the next digit.
                remainder *= 10;
                result.append(remainder / den); // Append the calculated digit to our result.
                
                // Update the remainder for the next iteration.
                remainder %= den;
            }
        
            // --- Step 7: Return the final result string ---
            // Once the loop finishes (either remainder became 0 or a repeat was found), return the complete string.
            return result.toString();
        }
    }
}