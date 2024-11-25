import java.io.*;
import java.util.*;


class GFG {
    // function to print the parent of each node
    public static void printParents(int node, Vector<Vector<Integer>> adj, int parent){
        // current node is Root, thus has no parent
        if (parent == 0){
            System.out.println(node + "-> Root");
        }else {
            System.out.println(node + "-> " + parent);
        }

        // Using DFS
        for (int i = 0; i < adj.get(node).size(); i++){
            if (adj.get(node).get(i) != parent){
                parentParents(adj.get(node).get(i), adj,node);
            }
        }
    }
    
    // function to print the children of each node
    public static void printChildren(int Root, Vector<Vector<Integer>> adj){
       // Queue for the BFS
       Queue<Integer> q = new LinkedList<>();
                q.add(Root);

                // visit arra to keep track o nodes that have beeb visited 
                int vis[] = new int[adj.size()];
                Arrays.fill(vis, 0);

                // Bfs
                while (q.size() != 0){
                    int node = q.peek();
                    q.remove();
                    vis[node] = 1;
                    System.out.print(node + "->");
                 
                    for (int i = 0; i < adj.get(node.size(); i++){
                        if (vis[adj.get(node).get(i)] == 0){
                            System.out.print(adj.get(node).get(i) + " ");
                            q.add(adj.get(node).get(i));
                        }
                    }
                    Sytem.out.println();
                }
            }

            // function to print the lead nodes
            public static void printLeadNodes(int Root, Vector<Vector<Integer>> adj){
                // leaf nodes have only one edge and are not the root
                for (int i = 1; i < adj.siz();i++){
                    if (adj.get(i).size() == 1 && i != Root){
                        System.out.println();
                    }
                }

            }

            // function to print the degrees of each node
            public static void printDegress(int Root, Vector<Vector<Integer>> adj){
                for (int i = 1; i <adj,size(); i++){
                    System.out.println(i + ":");
                    
                    if (i == Root){
                        System.out.println(adj.get(i).size()));
                    }else{
                        System.out.println(adj.get(i).size() - 1);
                    }
                }

                // driver code
                public static void main(String[] args){
                    // number of nodes
                    int N = 7, Root = 1;

                    // Adjacency list to store the tree
                    Vector<Vector<Integre>> adj = new Vector<Vector<Integer>>();
                    for (int i = 0; i < N + 1; i++){
                        adj.add(new Vector<Integer>());
                    }


                    // creating a new tree
                    adj.get(1).add(2);
                    adj.get(2).add(1);
                    adj.get(1).add(3);
                    adj.get(3).add(1);

                    adj.get(1).add(4);
                    adj.get(4).add(1);

                    adj.get(2).add(5);
                    adj.get(5).add(2);

                    adj.get(2).add(6);
                    adj.get(6).add(2);

                    adj.get(4).add(7);
                    adj.get(7).add(4);


                    // Printing the parents of each node
                    System.out.println("The parents of each node are:");
                    printParents(Root, adj, 0);

                    // Printing the children of each node
                    System.out.println(
                    "The children of each node are:");
                    printChildren(Root, adj);

                    // Printing the leaf nodes in the tree
                    System.out.println(
                    "The leaf nodes of the tree are:");
                    printLeafNodes(Root, adj);

                    // Printing the degrees of each node
                    System.out.println("The degrees of each node are:");
                    printDegrees(Root, adj);

