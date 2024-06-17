import java.lang.Math;
class Solution {
    public int mySqrt(int x) {
       if(x>=0){
         int result = (int) Math.sqrt(x);
         return result;
       } 
       return -1;
    }
}