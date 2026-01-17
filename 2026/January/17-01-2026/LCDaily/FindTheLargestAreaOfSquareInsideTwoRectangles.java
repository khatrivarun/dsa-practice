public class FindTheLargestAreaOfSquareInsideTwoRectangles {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long result = 0;
        int numberOfRectanges = bottomLeft.length;

        for (int i = 0; i < numberOfRectanges; i++) {
            int firstBottomXCoord = bottomLeft[i][0];
            int firstBottomYCoord = bottomLeft[i][1];
            int firstTopXCoord = topRight[i][0];
            int firstTopYCoord = topRight[i][1];

            for (int j = i + 1; j < numberOfRectanges; j++) {
                int secondBottomXCoord = bottomLeft[j][0];
                int secondBottomYCoord = bottomLeft[j][1];
                int secondTopXCoord = topRight[j][0];
                int secondTopYCoord = topRight[j][1];

                int finalBottomXCoord = Math.max(firstBottomXCoord, secondBottomXCoord);
                int finalBottomYCoord = Math.max(firstBottomYCoord, secondBottomYCoord);
                int finalTopXCoord = Math.min(firstTopXCoord, secondTopXCoord);
                int finalTopYCoord = Math.min(firstTopYCoord, secondTopYCoord);

                int height = finalTopYCoord - finalBottomYCoord;
                int width = finalTopXCoord - finalBottomXCoord;

                int squareLength = Math.min(height, width);

                if (squareLength > 0) result = Math.max(result, 1L * squareLength * squareLength);
            }
        }

        return result;
    }    
}
