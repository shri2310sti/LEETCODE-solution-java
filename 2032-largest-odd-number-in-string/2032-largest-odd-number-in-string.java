class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}



// class Solution {
//     public String largestOddNumber(String num) {
//         long n = Long.parseLong(num);
//         long ans = 0;
//         while(n > 0){
//             int digit = (int)(n % 10);
//             if(digit % 2 != 0)  {
//                 ans = n;
//                 break;
//             }
//             n/=10;
//         }
//         if(ans == 0) return "";
//         return Long.toString(ans);
//     }
// }