class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        
        for (String detail : details) {
            // Extract age substring and convert to integer
            String ageString = detail.substring(11, 13);
            int age = Integer.parseInt(ageString);
            
            // Check if age is greater than 60
            if (age > 60) {
                count++;
            }
        }
        
        return count;
    }
}
