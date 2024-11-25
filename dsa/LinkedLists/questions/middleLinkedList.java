
class Node {
    int data;
    Node next;

    // constructor 
    Node (int x){
        this.data = x;
        this.next = null;
    }
}

class middleLinkedList{
    // helper function to find length of linked list
    static int getLength(Node head){
        int length = 0;

        // traverse the entire linked list and increment
        while (head != null){
            length++;
            head = head.next;
        }

        return length;
    }
    // functio to get the middled value of the linked list
    static int getMiddle(Node head){
        int length = getLength(head);

        // traverse till we reached half of length
        int mid_index = length / 2;
        while (mid_index > 0){
            head = head.next;
            mid_index--;
        }
        return head.data;
    }
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println(getMiddle(head));
    }
}
