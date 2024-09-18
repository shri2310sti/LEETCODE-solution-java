import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integer array to a string array
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        // Sort the array with a custom comparator
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare by which combination is larger: a+b or b+a
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // We want descending order
            }
        });
        
        // If the largest number is "0", return "0"
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // Join all the elements in the array to form the largest number
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }
        
        return result.toString();
    }
}
