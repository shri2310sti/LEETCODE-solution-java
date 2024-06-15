class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = getValue(s.charAt(i));
            
            if (currValue < prevValue) {
                num -= currValue;
            } else {
                num += currValue;
            }

            prevValue = currValue;
        }

        return num;
    }

     private int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}