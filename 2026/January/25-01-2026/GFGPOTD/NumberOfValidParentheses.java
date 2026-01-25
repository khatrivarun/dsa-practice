public class NumberOfValidParentheses {
    int findWays(int n) {
        if (n % 2 != 0) return 0;

        int allowedPairs = n / 2;
        int[][] allPairCoombinations = new int[allowedPairs + 1][allowedPairs + 1];

        for (int i = 0; i <= allowedPairs; i++)
            allPairCoombinations[0][i] = 1;

        for (int i = 1; i <= allowedPairs; i++)
            for (int j = i; j <= allowedPairs; j++)
                allPairCoombinations[i][j] = allPairCoombinations[i][j - 1] + allPairCoombinations[i - 1][j];

        return allPairCoombinations[allowedPairs][allowedPairs];
    }    
}
