public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int stringOneLength = s1.length(), stringTwoLength = s2.length();
        int[][] dynamicProgrammingMatrix = new int[stringOneLength + 1][stringTwoLength + 1];

        // Setting up base cases for the dynamic programming matrix, rowise amd columnwise
        for (int i = 1; i <= stringOneLength; i++) dynamicProgrammingMatrix[i][0] = dynamicProgrammingMatrix[i - 1][0] + s1.charAt(i - 1);
        for (int i = 1; i <= stringTwoLength; i++) dynamicProgrammingMatrix[0][i] = dynamicProgrammingMatrix[0][i - 1] + s2.charAt(i - 1);

        // Lets run dynamic programming to calculate the solution
        for (int i = 1; i <= stringOneLength; i++) {
            for (int j = 1; j <= stringTwoLength; j++) {

                // If the characters are same, then we dont need to delete any character
                // so carry on with the old minimum sum from the previous iteration
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dynamicProgrammingMatrix[i][j] = dynamicProgrammingMatrix[i - 1][j - 1];

                // Else we check which will be smallest character we can yeet
                else dynamicProgrammingMatrix[i][j] = Math.min(
                    // Yeet from String One
                    dynamicProgrammingMatrix[i - 1][j] + s1.charAt(i - 1)
                    ,
                    // Or yeet from String Two
                    dynamicProgrammingMatrix[i][j - 1] + s2.charAt(j - 1)
                );
            }   
        }

        return dynamicProgrammingMatrix[stringOneLength][stringTwoLength];
    }    
}
