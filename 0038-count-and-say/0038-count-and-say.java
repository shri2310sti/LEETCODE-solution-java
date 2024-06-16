class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = countAndSayHelper(result);
        }
        return result;
    }
    
    private String countAndSayHelper(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char currentChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                count++;
            } else {
                sb.append(count);
                sb.append(currentChar);
                currentChar = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(currentChar);
        return sb.toString();
    }
}
