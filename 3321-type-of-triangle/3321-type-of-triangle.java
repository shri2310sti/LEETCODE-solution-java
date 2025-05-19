class Solution {

    // Method to classify the type of a triangle based on its side lengths
    public String triangleType(int[] sides) {
        // Sort the array to have the sides in ascending order
        Arrays.sort(sides);
      
        // Check for the triangle inequality theorem to determine if a triangle is possible
        if (sides[0] + sides[1] <= sides[2]) {
            // The sum of lengths of any two sides must be greater than the length of the third side
            return "none";
        }
      
        // Check if all sides are equal
        if (sides[0] == sides[2]) {
            // All sides are equal, therefore it's an equilateral triangle
            return "equilateral";
        }
      
        // Check if any two sides are equal
        if (sides[0] == sides[1] || sides[1] == sides[2]) {
            // Two sides are equal, therefore it's an isosceles triangle
            return "isosceles";
        }
      
        // If none of the sides are equal, it's a scalene triangle
        return "scalene";
    }
}