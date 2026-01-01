import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class IntersectioninYShapedLists {

    /*
     * Method used for the solution of the problem
     */
    public Node intersectPoint(Node head1, Node head2) {

        // Approach is to keep a history of travelled nodes
        // in the first list and check against the history
        // when travelling the second list to identify
        // intersection point
        HashMap<Node, Node> history = new HashMap<>();
        Node copyHead1 = head1;
        Node copyHead2 = head2;

        // Traversal 1: Building the history
        while (copyHead1 != null) {
            history.put(copyHead1, copyHead1);
            copyHead1 = copyHead1.next;
        }

        // Traversal 2: Check against the second list
        // if any node was visited before or not
        while (copyHead2 != null) {
            Node referenceNode = history.getOrDefault(copyHead2, null);

            if (referenceNode != null)
                return referenceNode;

            copyHead2 = copyHead2.next;
        }

        return null;
    }

    public static void main(String[] args) {

        IntersectioninYShapedLists solution = new IntersectioninYShapedLists();

        // Test Case for the solution
        Node node15 = new Node(15);
        Node node30 = new Node(30);
        node15.next = node30;

        Node node10 = new Node(10);
        node10.next = node15;

        Node node9 = new Node(9);
        node9.next = node15;

        Node node6 = new Node(6);
        node6.next = node9;

        Node node3 = new Node(3);
        node3.next = node9;

        System.out.println(solution.intersectPoint(node10, node3).data);

    }
}
