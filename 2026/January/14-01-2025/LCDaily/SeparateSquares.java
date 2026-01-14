import java.util.*;

class SeparateSquares {

    /**
     * Represents a node in the Segment Tree.
     * Each node covers a specific range of indices in our sorted X-coordinates array.
     */
    private static class SegmentTreeNode {
        int leftIndex, rightIndex; // The range of unique X-intervals this node manages
        int coverCount;            // How many active squares completely cover this range
        int coveredLength;         // The total length of the union of active intervals in this range
    }

    /**
     * A Segment Tree specialized for calculating the Union of Intervals.
     */
    private static class UnionAreaSegmentTree {
        private SegmentTreeNode[] nodes;
        private int[] sortedXCoordinates; // The map from Index -> Real X Value

        public UnionAreaSegmentTree(int[] sortedXCoordinates) {
            this.sortedXCoordinates = sortedXCoordinates;
            int n = sortedXCoordinates.length - 1;
            
            // Allocate tree array (4x size is standard for segment trees)
            this.nodes = new SegmentTreeNode[n * 4];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new SegmentTreeNode();
            }
            
            buildTree(1, 0, n - 1);
        }

        // Recursive function to initialize the tree
        private void buildTree(int nodeId, int left, int right) {
            nodes[nodeId].leftIndex = left;
            nodes[nodeId].rightIndex = right;
            
            if (left != right) {
                int mid = left + (right - left) / 2;
                buildTree(2 * nodeId, left, mid);
                buildTree(2 * nodeId + 1, mid + 1, right);
            }
        }

        // Updates the "Active Count" for a range of intervals
        // k = +1 (adding a square), k = -1 (removing a square)
        public void updateRange(int nodeId, int targetLeft, int targetRight, int k) {
            SegmentTreeNode node = nodes[nodeId];

            // If this node's range is fully contained in the update range
            if (node.leftIndex >= targetLeft && node.rightIndex <= targetRight) {
                node.coverCount += k;
                recalculateLength(nodeId);
                return;
            }

            // Otherwise, push update down to children
            int mid = (node.leftIndex + node.rightIndex) / 2;
            if (targetLeft <= mid) {
                updateRange(2 * nodeId, targetLeft, targetRight, k);
            }
            if (targetRight > mid) {
                updateRange(2 * nodeId + 1, targetLeft, targetRight, k);
            }
            
            recalculateLength(nodeId);
        }

        // Recalculates the 'coveredLength' for a specific node based on its children/status
        private void recalculateLength(int nodeId) {
            SegmentTreeNode node = nodes[nodeId];

            if (node.coverCount > 0) {
                // Case 1: This range is fully covered by at least one active square.
                // The covered length is the full physical width of this range.
                // width = realX[right + 1] - realX[left]
                node.coveredLength = sortedXCoordinates[node.rightIndex + 1] - sortedXCoordinates[node.leftIndex];
            } else if (node.leftIndex == node.rightIndex) {
                // Case 2: Leaf node with 0 cover count -> It's empty.
                node.coveredLength = 0;
            } else {
                // Case 3: Partial coverage. Sum the lengths of the children.
                node.coveredLength = nodes[2 * nodeId].coveredLength + nodes[2 * nodeId + 1].coveredLength;
            }
        }

        // Returns the total length of the union of active intervals (at the root)
        public int getTotalUnionWidth() {
            return nodes[1].coveredLength;
        }
    }

    /**
     * Main Logic
     */
    public double separateSquares(int[][] squares) {
        // Step 1: Coordinate Compression for X-axis
        // We need to map large/sparse X values to simple indices (0, 1, 2...)
        Set<Integer> uniqueXSet = new HashSet<>();
        for (int[] sq : squares) {
            uniqueXSet.add(sq[0]);          // Left X
            uniqueXSet.add(sq[0] + sq[2]);  // Right X
        }
        
        // Create sorted array of unique X coordinates
        int[] sortedX = new int[uniqueXSet.size()];
        int i = 0;
        for (int x : uniqueXSet) sortedX[i++] = x;
        Arrays.sort(sortedX);

        // Map real X values to their index in the sorted array
        Map<Integer, Integer> xToIndexMap = new HashMap<>();
        for (i = 0; i < sortedX.length; i++) {
            xToIndexMap.put(sortedX[i], i);
        }

        // Step 2: Create "Sweep Events"
        // A square is defined by a bottom edge (+1) and a top edge (-1)
        // Format: {yCoordinate, xStart, xEnd, type}
        List<int[]> events = new ArrayList<>();
        for (int[] sq : squares) {
            int x1 = sq[0];
            int y1 = sq[1];
            int size = sq[2];
            int x2 = x1 + size;
            int y2 = y1 + size;
            
            events.add(new int[]{y1, x1, x2, 1});  // Bottom Edge: Add coverage
            events.add(new int[]{y2, x1, x2, -1}); // Top Edge: Remove coverage
        }
        
        // Sort events by Y coordinate (Move from bottom to top)
        events.sort(Comparator.comparingInt(a -> a[0]));

        // Step 3: Pass 1 - Calculate Total Union Area
        UnionAreaSegmentTree tree = new UnionAreaSegmentTree(sortedX);
        double totalArea = 0.0;
        int prevY = 0;

        for (int[] event : events) {
            int currY = event[0];
            int x1 = event[1];
            int x2 = event[2];
            int type = event[3]; // +1 or -1

            // Add area of the strip between prevY and currY
            // Area = Height * (Width of Union of X intervals)
            totalArea += (double) (currY - prevY) * tree.getTotalUnionWidth();

            // Update the segment tree for the current event
            // Note: We use 'd.get(x2) - 1' because segment tree stores intervals.
            // Interval i represents range [sortedX[i], sortedX[i+1]].
            int leftIdx = xToIndexMap.get(x1);
            int rightIdx = xToIndexMap.get(x2) - 1;
            tree.updateRange(1, leftIdx, rightIdx, type);

            prevY = currY;
        }

        // Step 4: Pass 2 - Find the Split Line
        // The tree is now empty (count is 0 everywhere) because every +1 was matched by a -1.
        // We reuse it to simulate the sweep again until we hit half area.
        double targetArea = totalArea / 2.0;
        double currentArea = 0.0;
        prevY = 0;

        for (int[] event : events) {
            int currY = event[0];
            int x1 = event[1];
            int x2 = event[2];
            int type = event[3];

            // Calculate area of this strip
            double unionWidth = tree.getTotalUnionWidth();
            double stripArea = (double) (currY - prevY) * unionWidth;

            // Check if adding this strip exceeds our target
            if (currentArea + stripArea >= targetArea) {
                // The answer is inside this strip.
                // We need 'missingArea' more.
                // missingArea = heightNeeded * unionWidth
                double missingArea = targetArea - currentArea;
                return prevY + (missingArea / unionWidth);
            }

            currentArea += stripArea;
            
            // Update tree for next strip
            int leftIdx = xToIndexMap.get(x1);
            int rightIdx = xToIndexMap.get(x2) - 1;
            tree.updateRange(1, leftIdx, rightIdx, type);
            
            prevY = currY;
        }

        return 0.0; // Should not reach here
    }
}