

class Node{
    int data;
    Node next;

    Node(int new_data){
        this.data = new_data;
        this.next = null;
    }
}

class queueLinkedList{
    Node front, rear;

    queueLinkedList(){front = rear = null;}

    boolean isEmpty(){

        return front == null && rear == null;
    }

    void enqueue(int new_data){
        Node new_node = new Node(new_data);

        // if queue is empty the new node is both the front and rear
        if (rear == null){
            front = rear = new_node;
            return;
        }

        // add the new node at the end of the queue
        rear.next = new_node;
        rear = new_node;
    }

    void dequeue(){
        if (isEmpty()){
            System.out.println("Queue Underflow");
            return;
        }

        // store previous front and move front one node
        Node temp = front;
        front = front.next;
        
        // if front becomes null, then change rear also
        if (front == null){
            rear = null;
        }
    }

    // function to get the rear element of the queue
    int getRear(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return rear.data;
    }
}