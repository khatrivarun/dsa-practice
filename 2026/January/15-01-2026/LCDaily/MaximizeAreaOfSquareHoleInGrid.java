import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int hMax = 1, vMax = 1, count = 1;

        // Sort the bars which
        // we can remove
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        // Calculating the max amount of vertical
        // bars consecutively that we can remove from the grid
        for (int i = 1; i < vBars.length; i++)
            if (vBars[i] == vBars[i - 1] + 1)
                vMax = Math.max(vMax, ++count);
            else count = 1;

        count = 1;
        
        // Calculating the max amount of horizontal
        // bars consecutively that we can remove from the grid
        for (int i = 1; i < hBars.length; i++)
            if (hBars[i] == hBars[i - 1] + 1)
                hMax = Math.max(hMax, ++count);
            else count = 1;

        // We add 1 to the max bars resulting in cells
        // set free and check what is the minimum out of
        // vertical and horizontal maxes so we can build
        // a proper square hole
        int result = Math.min(vMax + 1, hMax + 1);

        // Return the area of the square
        return (int) Math.pow(result, 2);
    }    
}
