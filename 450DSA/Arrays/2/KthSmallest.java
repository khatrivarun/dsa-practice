import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Integer integer : arr) heap.add(integer);

        int result = 0;
        for (int i = 1; i <= k; i++) result = heap.poll();

        return result; 
    }    
}
