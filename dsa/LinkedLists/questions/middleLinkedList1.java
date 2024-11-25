class Node {
    int data;
    Node next;

    Node (int x){
        this.data = x;
        this.next = null;
    }
}

class middleLinkedList1{
    static int getMiddle(Node head){
        // initialize the slow and fast pointer
        Node slow_ptr = head;
        Node fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            
            // move the slow pointer by one node
            slow_ptr = slow_ptr.next;
        }

        // return slow pointer data
        return slow_ptr.data;
    }
    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 10 -> 20 -> 30 -> 40 -> 50 -> 60
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println(getMiddle(head));
    }
}
