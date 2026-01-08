import java.util.ArrayList;

public class MinAndMaxInArray {
    public ArrayList<Integer> getMinMax(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Integer.MAX_VALUE);
        result.add(Integer.MIN_VALUE);

        for (int i = 0; i < arr.length; i++) {
            result.set(0, Math.min(result.get(0), arr[i]));
            result.set(1, Math.max(result.get(1), arr[i]));
        }

        return result;        
    }    
}
