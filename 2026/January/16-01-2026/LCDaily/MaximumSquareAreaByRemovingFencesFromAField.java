import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSquareAreaByRemovingFencesFromAField {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> horizontalDistances = generateAllPossibleDistancesBetweenFences(hFences, m);
        Set<Integer> verticalDistances = generateAllPossibleDistancesBetweenFences(vFences, n);

        horizontalDistances.retainAll(verticalDistances);

        int result = -1;
        int modulus_seven = (int) 1e9 + 7;
        for (Integer distance : horizontalDistances) result = Math.max(result, distance);

        return result <= 0 ? -1 : (int) (1L * result * result % modulus_seven);
    }

    public Set<Integer> generateAllPossibleDistancesBetweenFences(int[] fences, int boundary) {
        int[] fencePositions = Arrays.copyOf(fences, fences.length + 2);
        fencePositions[fences.length] = 1;
        fencePositions[fences.length + 1] = boundary;

        Arrays.sort(fencePositions);

        Set<Integer> allDistances = new HashSet<>();

        for (int i = 0; i < fencePositions.length; i++) {
            for (int j = 0; j < i; j++) {
                allDistances.add(fencePositions[i] - fencePositions[j]);
            }
        }

        return allDistances;
    }
}
