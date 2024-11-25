class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}


public class Main{
    // function to insert node into an empty circular linked list
    static Node insertInEmptList(Node last, int data){
        if (last != null) return last;

        // create a new node
        Node newNode = new Node(data);

        // point the new node to itself
        newNode.next = newNode;

        // update last to point to the new node
        last = newNode;
        return last;
    }

    // function to print the list
    static void printList(Node last){
        if (last == null) return;

        // start from the head node
        Node head = last.next;

        while (true){
            System.out.print(head.data + " " );
            head = head.next;
            if (head == last.next) break;
        }
        System.out.println();
    }

    // fuction to insert a node at the beginning
    public static Node insertAtBeginning(Node last, int value){
        Node newNode = new Node(value);

        // if the list is empy make a new node to point to itself
        if (last == null){
            newNode.next = newNode;
            return newNode;
        }

        // insert the new node at the beginning
        newNode.next = last.next;
        last.next = newNode;

        return last;
    }

    // insert a node at the end of a circular linked list
    static Node insertEnd(Node tail, int value){
        Node newNode = new Node(value);
        if (tail == null){
            tail = newNode;
            newNode.next = newNode;
        } else{
            // insert the new node after the current tail
            // update the tail pointer
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        return tail;
    }

    // inserting at a specific position
    static Node insertAtPositon(Node last, int data){
        if (last == null){
            // if the list is empty
            if (pos != 1){
                System.out.println("Invalid position");
                return last;
            }
            // create a new node and make it point to itself
            Node newNode = new Node(data);
            last = newNode;
            last.next = last;
            return last;
        }

        // create a new node with the given data
        Node newNode = new Node(data);

        // curr will point to head initially
        Node curr = last.next;

        if (pos == 1){
            // insert at the beginning
            newNode.next = curr;
            last.next = newNode;
            return last;
        }

        // traverse the list to find the insertion point
        for (int i = 1; i < pos - 1; ++i){
            curr = curr.next;

            // if position is out of bound
            if (curr = last.next){
                System.out.println("Invalid position!");
                return last;
            }
        }

        // insert the new node at the desired positon
        newNode.next = curr.next;
        curr.next = newNode;

        // update last if the new Node is inserted at the end
        if (curr == last){
            last = newNode;
        }

        return last;
    }



    public static void main(String[] args){
        Node last = null;

        // insert a node into the empty list
        last = insertInEmpytyList(last, 1);

        //print the list
        System.out.print("List after insertion: ");
        printList(last);
    }


}
