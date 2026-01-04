import java.util.PriorityQueue;

public class KthSmallestElementInAMatrix {
    public int kthSmallest(int[][] mat, int k) {

        // Logic is to add all elements of the matrix to the
        // min heap and poll it for the Kth smallest element
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                heap.add(mat[i][j]);

        // Polling for the kth smallest element
        int counter = 0;
        while(!heap.isEmpty()) {
            int smallest = heap.poll();
            counter += 1;

            if (counter == k) return smallest;
        }

        return -1;
    }
}
