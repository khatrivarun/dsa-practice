package GFGPOTD;

public class WordSearch {
    private int wordLength;
    private int rows;
    private int columns;

    public boolean findMatch(char[][] mat, String word, int x, int y, int wordIndex) {
        if (wordIndex == wordLength)
            return true;

        if (x < 0 || y < 0 || x >= rows || y >= columns)
            return false;

        if (mat[x][y] == word.charAt(wordIndex)) {
            char temp = mat[x][y];
            mat[x][y] = '#';

            boolean res = findMatch(mat, word, x - 1, y, wordIndex + 1) ||
                    findMatch(mat, word, x + 1, y, wordIndex + 1) ||
                    findMatch(mat, word, x, y - 1, wordIndex + 1) ||
                    findMatch(mat, word, x, y + 1, wordIndex + 1);

            mat[x][y] = temp;
            return res;
        }

        return false;

    }

    public boolean isWordExist(char[][] mat, String word) {
        wordLength = word.length();
        rows = mat.length;
        columns = mat[0].length;

        if (wordLength > rows * columns) return false;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (mat[row][column] == word.charAt(0))
                    if (findMatch(mat, word, row, column, 0)) return true;
            }
        }

        return false;
    }
}
