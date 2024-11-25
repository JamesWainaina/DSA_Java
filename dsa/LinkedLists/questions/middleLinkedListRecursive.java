

// implemnting finding the middle of a linked list recursively

class middleLinkedListRecursive {
    static class Node{
        int data;
        Node next;
    }

    // create new Node
    static Node NewNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    static int n;
    static Node mid;


    /// function for finding midPoint recursively
    static void midpoint_util(Node head){


        // if we reached end of linked list
        if (head == null){
            n = (n) / 2;
            return ;
        }

        n = n + 1;

        midpoint_util(head.next);


        // rolling back, decrement n by one
        n = n - 1;

        if (n == 0){
            // final answer
            mid = head;
        }
    }
    static Node midPoint(Node head){
        mid = null;
        n = 1;
        mid_point(head);
        return mid;
    }
    public static void main(String args[]){
        Node head = newLNode(1);
        head.next = newLNode(2);
        head.next.next = newLNode(3);
        head.next.next.next = newLNode(4);
        head.next.next.next.next = newLNode(5);
        Node result = midpoint(head);
        System.out.print( result.data );
    }
}


