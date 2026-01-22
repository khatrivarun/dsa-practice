import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        int requirement = nums.length / 3;

        for (Integer integer : nums) counts.put(integer, counts.getOrDefault(integer, 0) + 1);

        for (Map.Entry<Integer, Integer> count : counts.entrySet())
            if (count.getValue() > requirement) result.add(count.getKey());

        return result;
    }    
}
