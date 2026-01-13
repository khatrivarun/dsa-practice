public class SeparateSquares {
    private int[][] globalSquares;
    private double totalArea;
    private double precision = 1e-5;

    public boolean dissectAndCheckArea(double lineCoordinate) {
        double belowArea = 0.0;
        double targetArea = this.totalArea / 2.0;

        // Calculate the effective lower height
        // and check if its too high than required
        for (int[] square : this.globalSquares) {
            int yCoordinate = square[1];
            int sideLength = square[2];

            // There can be a possibility if the entire square is below the line
            // or it could be completely above the line
            double actualHeightPossible = Math.max(0, Math.min(lineCoordinate - yCoordinate, sideLength));
            belowArea += (double) actualHeightPossible * sideLength;
        }

        return belowArea >= targetArea;
    }
    
    public double separateSquares(int[][] squares) {
        this.globalSquares = squares;
        this.totalArea = 0.0;

        // Binary Search Parameters
        double low = 0.0;
        double high = 0.0;

        // Calculating total area of the entire area
        for (int[] square : squares) {
            int yCoordinate = square[1];
            int sideLength = square[2];

            // Adding all areas together
            this.totalArea += (double) sideLength * sideLength;

            // Checking the total height of the whole thing
            high = Math.max(high, yCoordinate + sideLength);
        }

        while (high - low > this.precision) {
            double mid = low + (high - low) / 2.0;

            if (dissectAndCheckArea(mid)) {
                // We may have exact
                // or the answer is below us
                high = mid;
            } else {
                // Else is its way above
                low = mid;
            }
        }

        // If we have the exact answer
        return high;
    }
}
