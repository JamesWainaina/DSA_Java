public class Node {
    public Vertex data;
    public Node next;

    public Node(Vertex data){
        this.data = data;
        this.next = null;
    }

    public void setNextNode(Node node){
        this.next = node;
    }

    public Node getNextNode(){
        return this.next;
    }
}
