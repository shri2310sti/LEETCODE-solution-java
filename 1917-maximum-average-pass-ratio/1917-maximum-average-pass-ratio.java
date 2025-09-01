import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap to store classes by their marginal gain
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        // Calculate initial marginal gains and add to the heap
        for (int[] cls : classes) {
            int passi = cls[0], totali = cls[1];
            double gain = getGain(passi, totali);
            maxHeap.offer(new double[]{gain, passi, totali});
        }
        
        // Assign extra students
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int passi = (int) top[1], totali = (int) top[2];
            
            // Assign one extra student to this class
            passi++;
            totali++;
            extraStudents--;
            
            // Recalculate the marginal gain and push back to the heap
            gain = getGain(passi, totali);
            maxHeap.offer(new double[]{gain, passi, totali});
        }
        
        // Calculate the final average pass ratio
        double totalPassRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] cls = maxHeap.poll();
            int passi = (int) cls[1], totali = (int) cls[2];
            totalPassRatio += (double) passi / totali;
        }
        
        return totalPassRatio / classes.length;
    }
    
    // Method to calculate the marginal gain of adding one extra student
    private double getGain(int passi, int totali) {
        return ((double) (passi + 1) / (totali + 1)) - ((double) passi / totali);
    }
}