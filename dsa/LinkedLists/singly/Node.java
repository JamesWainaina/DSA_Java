// defination of a Node in a singly linked list

public class Node {
    int data;
    Node next;

    // constructor to initialize the node with data 
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    // traversal of a linked list
    public static void traverseLinkedList(Node head){
        // start from the head of the linked list
        Node current = head;

        // traverse the linked list until reaching the end
        while (current != null){
            System.out.println(current.data + " ");

            // then move to the next node
            current = current.next;
        }
        System.out.println();
    }
    
    // searching in a linkedList
    public boolean searchLinkedList(Node head, int target){
        // traverse the linked list
        while (head != null){
            // check if the current node's data  matches the target value
            if (head.data == target){
                return true;
            }

            // else move to the next node
            head = head.next;
        }

        // value not found
        return false;
    }

    // finding the length of a linked list
    public int findLength(Node head){

        //initialize a countre for the length
        Node current = head;
        // traverse the list and increment the length for each
        while (current != null){
            length++;
            current = current.next;
        }
        return length;
    }


    // inserting into a single list
    // at the begginning
    public Node insertAtBeginning(Node head, int value){
        Node newNode = new node(value);
        

        // set the pointer of the new node to the current
        newNode.next = head;

        // move the head to pint to the new Node
        head = newNode;

        // return the new head of the linked list
        return head;
    }

    // insert at the end of the singly linked list
    public static Node insertAtEnd(Node head, int value){
        // create a  new node with the given value
        Node newNode = new Node(value);

        // it the list is empty, make the new node the head
        if (head == null){
            return newNode;
        }

        // traverse the list until the last node is reached
        Node curr = head;
        while (curr.next != null){
            curr = curr.next;
        }

        // link the  new node to the current last node
        curr.next = newNode;
       
        return head;
    }

    // insert at a specific position of the list
    public static Node insertPos(Node head, int pos, int data){
        if (pos < 1){
            System.out.println("Invalid position");
            return  head;
        }

        // special case for inserting at the head
        if (pos == 1){
            Node temp = new Node(data);
            temp.next = head;
            return temp;
        }

        // traverse the list to find the insertion point
        Node prev = head;
        int count = 1;
        while (count < pos - 1 && prev != null){
            prev = prev.next;
            count++;
        }
        // if position is greater than the number of nodes
        if (prev = null) {
            System.out.println("Invalid position!");
            return head;
        }

        return head;
    }
    

    // deleting in a singly linked list
    // at the beginning
    static Node removeFirstNode(Node head){
        if (head == null) {
            return null;
        }

        // move the head pointer to the next node
        Node temp = head;
        head = head.next;

        return head;
    }

    // deleting at the end
    Node removeLastNode(Node head){
        // if the list is empty, return null
        if (head == null){
            return null;
        }

        // if the list has only one node remove the headn node
        if (head.next == null){
            head = null;
            return null;
        }

        // find the second last node
        Node second_last = head;
        while(second_last.next.next != null){
            second_last = second_last.next;
        }

        // remove the last element
        second_last.next = null;
        return head;
    }


    // deleting at a specific position of linkedList
    public void deleteAtPosition(Node head, int positon){
        // if the list is empty or the position is invalid
        if (head == null || positon < l){
            return;
        }

        // if the head needs to be deleted
        if (position == 1){
            Node temp = head;
            head = head.next;
            temp = null;
            return;
        }

        // traverse the node before the position to be deleted
        Node current = head;
        for (int i = 1; i < position - 1 && current != null, i++){
            current = current.next;
        }

        // check if the position is out of range
        if (current == null || current.next == null){
            return;
        }
        // store the node to be deleted
        Node temp = current.next;


        // update the links to bypass the node to be deleted
        current.next = current.next.next;

        // delete the node 
        temp = null;
    }



    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Test Case 3: Multiple Nodes");
        traverseLinkedList(head);
    }
}

