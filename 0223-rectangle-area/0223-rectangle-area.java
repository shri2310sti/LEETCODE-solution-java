class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Step 1: Calculate area of first rectangle
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        
        // Step 2: Calculate area of second rectangle
        int area2 = (bx2 - bx1) * (by2 - by1);
        
        // Step 3: Calculate overlap rectangle coordinates
        int x_left = Math.max(ax1, bx1);
        int x_right = Math.min(ax2, bx2);
        int y_top = Math.min(ay2, by2);
        int y_bottom = Math.max(ay1, by1);
        
        // Step 4: Calculate overlap area (if it exists)
        int overlapArea = 0;
        if (x_right > x_left && y_top > y_bottom) {
            overlapArea = (x_right - x_left) * (y_top - y_bottom);
        }
        
        // Step 5: Return total area minus overlap
        return area1 + area2 - overlapArea;
    }
}