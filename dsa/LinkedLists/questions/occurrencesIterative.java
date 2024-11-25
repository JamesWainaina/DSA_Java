
// number of occurrences of Node 

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class occurrencesIterative{
    static int count(Node head, int key){
        Node curr = head;
        int count = 0;
        while(curr != null){
            if (curr.data == key){
                count++;
            }
            curr = curr.next;
        }
        return count;
    }
    public static void main(String[] args) {

        // Hard coded linked list: 1 -> 2 -> 1 -> 2 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        int key = 1;
        System.out.println(count(head, key));
    }
}
