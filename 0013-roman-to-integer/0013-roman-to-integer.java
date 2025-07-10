class Solution {
    public int romanToInt(String s) {
        int preV = 0;
        int ans = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int curr = getValue(s.charAt(i));

            if(preV > curr) ans -= curr;
            else ans += curr;
            preV = curr;
        }
        return ans ;
    }
    private int getValue (char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}