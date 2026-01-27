import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostPathWithEdgeReversals {
    private final int infinity = Integer.MAX_VALUE / 2;
    
    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];

        Arrays.setAll(graph, k -> new ArrayList<>());

        for(int[] edge: edges) {
            int sourceNode = edge[0];
            int destinationNode = edge[1];
            int cost = edge[2];

            graph[sourceNode].add(new int[] {destinationNode, cost});
            graph[destinationNode].add(new int[]{sourceNode, 2 * cost});
        }

        int[] minimumCosts = new int[n];
        Arrays.fill(minimumCosts, infinity);
        minimumCosts[0] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        priorityQueue.add(new int[]{0, 0});

        while (!priorityQueue.isEmpty()) {
            int[] currentNodeData = priorityQueue.poll();
            int currentNode = currentNodeData[0];
            int currentCost = currentNodeData[1];

            if (currentCost > minimumCosts[currentNode]) continue;
            if (currentNode == n - 1) return currentCost;

            for (int[] neighbour : graph[currentNode]) {
                int nextNode = neighbour[0];
                int edgeWeight = neighbour[1];

                int totalCost = currentCost + edgeWeight;

                if (totalCost < minimumCosts[nextNode]) {
                    minimumCosts[nextNode] = totalCost;
                    priorityQueue.offer(new int[]{nextNode, totalCost});
                }
            }
        }

        return -1;
    }    
}
