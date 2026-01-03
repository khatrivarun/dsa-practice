import java.util.LinkedList;
import java.util.Collections;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}

public class FlatteningALinkedList {

    // Helper method to visualize the list
    // It prints the "Head" node, then all nodes directly beneath it
    public void printList(Node node) {
        while (node != null) {
            System.out.println("Main Node: " + node.data);
            System.out.println("Bottom Nodes: ");

            Node bottomNode = node.bottom;
            while (bottomNode != null) {
                System.out.println("Node: " + bottomNode.data);
                bottomNode = bottomNode.bottom;
            }

            node = node.next;

            System.out.println("--------------");
        }
    }

    public Node flatten(Node root) {
        Node copyRoot = root;

        // temporary container to hold all values
        LinkedList<Integer> allElements = new LinkedList<>();

        // Go through every node in the 2D structure
        while (copyRoot != null) {
            allElements.add(copyRoot.data);

            Node bottom = copyRoot.bottom;

            while(bottom != null) {
                allElements.add(bottom.data);
                bottom = bottom.bottom;
            }
            
            copyRoot = copyRoot.next;
        }

        // Sort all collected values
        Collections.sort(allElements);

        // Detach the original list structure to prevent interference
        root.next = null;
        copyRoot = root;

        // Create a brand NEW node for every sorted integer
        for (Integer integer : allElements) {
            copyRoot.bottom = new Node(integer);

            copyRoot = copyRoot.bottom;
        }

        return root.bottom;
    }

    public static void main(String[] args) {

        FlatteningALinkedList solution = new FlatteningALinkedList();

        Node head = new Node(5);
        Node node10 = new Node(10);
        Node node19 = new Node(19);
        Node node28 = new Node(28);

        head.next = node10;
        node10.next = node19;
        node19.next = node28;

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        node10.bottom = new Node(20);
        node19.bottom = new Node(22);
        node28.bottom = new Node(40);
        node28.bottom.bottom = new Node(45);

        solution.printList(head);

        System.out.println("---------------------- SOLUTION ---------------------- ");

        Node solutionNode = solution.flatten(head);
        solution.printList(solutionNode);
    }

}
