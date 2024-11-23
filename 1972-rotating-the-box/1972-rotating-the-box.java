class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; // Number of rows
        int n = box[0].length; // Number of columns

        // Simulate gravity for each row
        for (int row = 0; row < m; row++) {
            int emptySlot = n - 1; // Position where the next stone can fall
            for (int col = n - 1; col >= 0; col--) {
                if (box[row][col] == '*') {
                    // Obstacle found, reset the emptySlot pointer
                    emptySlot = col - 1;
                } else if (box[row][col] == '#') {
                    // Move the stone to the farthest right position
                    box[row][col] = '.';
                    box[row][emptySlot] = '#';
                    emptySlot--;
                }
            }
        }

        // Rotate the box 90 degrees clockwise
        char[][] rotated = new char[n][m];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                rotated[col][m - 1 - row] = box[row][col];
            }
        }

        return rotated;
    }
}
