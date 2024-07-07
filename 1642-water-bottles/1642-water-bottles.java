class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = 0;
        int emptyBottles = 0;
        
        while (numBottles > 0) {
            // Drink all current full bottles
            totalDrunk += numBottles;
            emptyBottles += numBottles;
            numBottles = 0;
            
            // Exchange empty bottles for full bottles
            if (emptyBottles >= numExchange) {
                numBottles = emptyBottles / numExchange;
                emptyBottles = emptyBottles % numExchange;
            } else {
                break;
            }
        }
        
        return totalDrunk;
    }
}

