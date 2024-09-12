import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }
    // Method to return all vertices in the graph
    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }


    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight){
        // check if it is weighted
        if (!this.isWeighted){
            weight = null;
        }
        // add a value and connect to the second vertex
        vertex1.addEdge(vertex2, weight);

        // check it is  directed
        if (!this.isDirected){
            vertex2.addEdge(vertex1, weight);
        }
    }
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if (!this.isDirected){
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }
    public boolean isWeighted(){
        return this.isWeighted;
    }
    public boolean isDirected(){
        return this.isDirected;
    }
    public Vertex getVertexByValue(String value){
        for (Vertex v: this.vertices){
            if(v.getData() == value){
                return v;
            }
        }
        return null;
    }

    public  void print(){
        for (Vertex v: this.vertices){
            v.print(isWeighted);
        }
    }
    public static void main(String[] args) {
        Graph busNetwork = new Graph(true, false);
        Vertex clifStation = busNetwork.addVertex("Clifton");
        Vertex capMayStation = busNetwork.addVertex("Cape May");

        busNetwork.addEdge(clifStation, capMayStation, 1000 );

        busNetwork.print();
    }
}
