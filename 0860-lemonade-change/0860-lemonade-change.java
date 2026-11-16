class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Arrays.sort(bills);
        int temp[] = new int[3];
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5) temp[0]++;
            else if(bills[i] == 10){
                if(temp[0] > 0) {
                    temp[1]++;
                    temp[0]--;
                } else return false;
            }
            else {
                if(temp[0] > 0 && temp[1] > 0){
                    temp[2]++;
                    temp[1]--;
                    temp[0]--;
                }else if(temp[0] >= 3) {
                    temp[0]--; temp[0]--; temp[0]--;
                }
                else return false;
            }
        }
        return true;
    }
}