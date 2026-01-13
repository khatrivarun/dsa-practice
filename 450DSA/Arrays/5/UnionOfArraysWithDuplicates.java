import java.util.ArrayList;
import java.util.HashMap;

public class UnionOfArraysWithDuplicates {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int i : a)
            if (!cache.containsKey(i))
                cache.put(i, i);
                
        for (int i : b)
            if (!cache.containsKey(i))
                cache.put(i, i);

        return new ArrayList<>(cache.keySet());
    }
}
