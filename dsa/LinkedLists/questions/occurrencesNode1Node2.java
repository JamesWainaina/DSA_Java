/*
 * Given two linked lists head1 and head2, the task is to find occurrences of head2 in head1.
 *
 * Approach 1: To solve the problem using Sliding Window Approach:
 *
 *
 * The idea is to use sliding window approach. We will traverse the first linked list head1, and at each node, we will check if the current node is equal to the first node of head2. If it is, then we will start a new traversal of both linked lists from this node, and check if all nodes in head2 match the nodes in head1 starting from this node. If they match, we will count it as an occurrence.
 *
 *
 *
 */

class Node{
    int val;
    Node next;

    public Node(int x){
        val =x;
        next = null;
    }
}

class occurrencesNode1Node2{
    static int countOccurrences(Node head1, Node head2){
        int count = 0;

        while (head1 != null){
            Node p1 = head1;
            Node p2 = head2;

            while (p1 != null && p2 != null && p1.val == p2.val){
                p1 = p1.next;
                p2 = p2.next;
            }

            if (p2 == null){
                count++;
            }
            head1 = head1.next;
        }
        return count;
    }

     // Drivers code
    public static void main(String[] args) {
        // Initialize the first linked list
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next.next = new Node(4);
 
        // Initialize the second linked list
        Node head2 = new Node(2);
        head2.next = new Node(4);
 
        // Count the occurrences of head2 in head1
        int count = countOccurrences(head1, head2);
 
        // Output the result
        System.out.println("Occurrences of head2 in head1: " + count);
    }
}

