import java.util.PriorityQueue;

class DLLNode {
    private long data;
    private int index;
    private DLLNode nextNode;
    private DLLNode previousNode;
    private boolean removed = false;

    public DLLNode(long data, int index,DLLNode nextNode, DLLNode previousNode) {
        this.data = data;
        this.index = index;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public DLLNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DLLNode nextNode) {
        this.nextNode = nextNode;
    }

    public DLLNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DLLNode previousNode) {
        this.previousNode = previousNode;
    }

    public boolean getRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}

class Pair implements Comparable<Pair> {
    long sum;
    int index;
    DLLNode leftNode;
    
    public Pair(long sum, int index, DLLNode leftNode) {
        this.sum = sum;
        this.index = index;
        this.leftNode = leftNode;
    }

    @Override
    public int compareTo(Pair other) {
        int sumComparison = Long.compare(this.sum, other.sum);
        if (sumComparison != 0) {
            return sumComparison;
        }
        return Integer.compare(this.index, other.index);
    }
}

public class MinimumPairRemovalToSortArray {
    public int minimumPairRemoval(int[] nums) {
        DLLNode head = new DLLNode(nums[0], 0, null, null);
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int result = 0;

        int ruleBreakers = 0;
        
        DLLNode pointerHead = head;

        for (int i = 1; i < nums.length; i++) {
            pointerHead.setNextNode(new DLLNode(nums[i], i, null, pointerHead));

            priorityQueue.add(new Pair(pointerHead.getData() + pointerHead.getNextNode().getData(), pointerHead.getIndex(), pointerHead));

            if (pointerHead.getData() > pointerHead.getNextNode().getData()) ruleBreakers += 1;

            pointerHead = pointerHead.getNextNode();
        }

        if (ruleBreakers == 0) return 0;


        while (ruleBreakers > 0 && !priorityQueue.isEmpty()) {
            Pair minPair = priorityQueue.poll();
            DLLNode left = minPair.leftNode;
            DLLNode right = left.getNextNode();

            if (left.getRemoved() || right == null || right.getRemoved() || left.getNextNode() != right) {
                continue;
            }

            if (left.getData() + right.getData() != minPair.sum) {
                continue; 
            }

            if (left.getPreviousNode() != null && left.getPreviousNode().getData() > left.getData()) ruleBreakers -= 1; 
            if (left.getData() > right.getData()) ruleBreakers -= 1;
            if (right.getNextNode() != null && right.getData() > right.getNextNode().getData()) ruleBreakers -= 1;

            left.setData(left.getData() + right.getData());

            right.setRemoved(true);
            left.setNextNode(right.getNextNode());
            if (right.getNextNode() != null) right.getNextNode().setPreviousNode(left);

            if (left.getPreviousNode() != null) {
                if (left.getPreviousNode().getData() > left.getData()) ruleBreakers++;
                priorityQueue.add(new Pair(left.getPreviousNode().getData() + left.getData(), left.getPreviousNode().getIndex(), left.getPreviousNode()));
            }
            
            if (left.getNextNode() != null) {
                if (left.getData() > left.getNextNode().getData()) ruleBreakers++;
                priorityQueue.add(new Pair(left.getData() + left.getNextNode().getData(), left.getIndex(), left));
            }

            result += 1;
        }

        return result;
    } 
}
