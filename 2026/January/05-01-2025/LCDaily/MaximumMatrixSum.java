public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long result = 0;
        int countNegativeNumbers = 0;

        // Lets count all the negative numbers
        // Need to find out if they are even
        // in number or odd to solve the question
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] < 0) countNegativeNumbers += 1;

        // If there even number of negative
        // numbers, those can be all converted
        // to positive numbers
        if (countNegativeNumbers % 2 == 0)
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++)
                    result += Math.abs(matrix[i][j]);

        // Else lets just leave one of the
        // "smallest" negative numbers as
        // negative and convert all to positive
        else {
            int minimumNumber = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++)
                    minimumNumber = Math.min(minimumNumber, Math.abs(matrix[i][j]));

            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++)
                    result += Math.abs(matrix[i][j]);

            result -= minimumNumber;
            result += -minimumNumber;
        }

        return result;
    }    
}
