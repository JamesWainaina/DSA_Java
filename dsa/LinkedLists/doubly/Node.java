class Node {
    int data;
    Node prev;
    Node Next;

    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;

    }
}

class GfG{
    // forward traversal
    static void forwardTraversal(Node head){
        Node curr = head;

        // continue until the node is null
        while (curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
    }


    // backward traversal
    static void backwardTraversal(Node tail){
     // start traversing from the tail
        Node curr = tail;

        // continue until the node is null
        while (curr != null){
            System.out.println(curr.data + " ");

            curr = curr.prev;
        }
        System.out.println();
    }

    // finding the length of a linked list
    static int findLength(Node head){
        int count = 0;

        for (Node curr = head; curr != null; curr= curr.next){
            count++;
        }
        return count;
    }

    // insert at the begginning
    static Node insertBegin(Node head, int data){
        // create a new node
        Node new_node =  new Node(data);

        new_node.next = head;

        if (head != null){
            head.prev = new_node;
        }

        return new_node;
    }


    // insert at the end of the linked list
    public static Node insertEnd(Node head, int data){
        Node newNode = new Node(data);

        // if the list is empty set the new new node as the head
        if (head == null){
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }

            curr.next = newNode;

            // set the previous newo to the last node
            newNode.prev = curr;
        }
        return head;
    }


    // insert at a specific position
    public static Node insertAtPosition(Node head, int pos, int new_data){
        Node new_node = new Node(new_data);
        
        // check if the position is at the begginning
        if (pos == 1){
            new_node.next = head;
            // if the linked list is not emptym set the prev pf head to new node
            if (head != null){
                head.prev = new_node;
            }

            // set the new node as the head of the linked list
            head = new_node;
            return head;
        }

        Node curr = head;

        // traverse the list to find the node before the insertion ppint
        for (int i = 1; i < pos - 1 && curr != null){
            curr = curr.next;
        }

        // if the position is out of bounds
        if (curr == null){
            System.out.println("position is out of bounds.");
            return head;
        }

        // set the prev of new node to curr
        new_node.prev = curr;

        // set the next of the current node to new node
        new_node.next = curr.next;

        // update the next of the current node to new node
        curr.next = new_node;

        // if the new node is not the last node updata
        if (new_node.next != null){
            new_node.next.prev = new_node;
        }
        // return head
        return head;
    }

    // deletion of at the beggining of the list
    public static Node delHead(Node head){
        if (head == null){
            return null;
        }

        // store in temp for deletion later
        Node temp = head;

        // move the head to the next node
        head = head.next;
        // set teh prev of the new head
        if (head != null){
            head.prev = null;
        }
        return head;
    }

    // deletion at the end of a list
    public static Node delLast(Node head){
        // edge case
        if (head == null){
            return null;
        }

        if (head.next == null){

            return null;
        }

        // travserse to the last node
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        // update the previous node's next pointer
        if (curr.prev != null){
            curr.prev.next = null;
        }
        return head;
    }


    // delete at a specific position of a linked list
    public static Node delPos(Node head, int pos){
        // if the list is empty
        if (head == null){
            return head;
        }

        Node curr = head;

        // traverse the node at the given position
        for (int i = 1; curr != null && i < pos; ++i){
            curr = curr.next;
        }

        // check if the pos is out of range
        if (curr == null){
            return head;
        }
        
        // update the previous node's pointer
        if (curr.prev != null){
            curr.prev.next = curr.next;
        }
        // update the next node's prev pointer
        if (curr.next != null){
            curr.next.prev = curr.prev;
        }

        // if the node to be deleted is the head node
        if (head == curr){
            head = curr.next;
        }

        return head;
    }


        



    public static void main(String[] args){
        Node head = new Node(1);
        Node second = new Node(2);
        Node third  = new Node(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        System.out.println("forward Traversal:");

        forwardTraversal(head);

        System.out.println("Backward Traversal:");
        backwardTraversal(third);

    }
}
