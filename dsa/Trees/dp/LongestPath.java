import java.util.*;
/*
 *
 * given a tree of N nodes, calculate longest path betwwen any two nodes(Known as diameter of tree).
 */

class longestPath{
    static List<List<Integer>> adj;
    static int n; // number of nodes

    
    public static int[] dfs(int node, int parent){
        int maxDist = 0;
        int farthestNode = node;


        for (int neighbour: adj.get(node)){
            if (neighbour == parent) continue;

            int[] result = dfs(neighbour, node);
            int dist = result[0] + 1;

            if (dist > maxDist){
                maxDist = dist;
                farthestNode = result[1];
            }
        }

        return new int[]{maxDist, farthestNode};// return the max distance and the farthest node
    }
      public static int findDiameter(){
        // perform Dfs from an arbirary node
        int[] result = dfs(1, -1);
        int farthest1 = result[1];

        // perform dfs from the farthest nod found in step 1
        result = dfs(farthest1, -1);
        return result[0]; // the second Dfs gives the diameter of the tree
      }

      public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

       // input the number of nodes
        n = sc.nextInt();

        // initialize adjacency list
        adj =  new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        // input edges
        for (int i = 0; i < n -1 ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

       System.out.println(findDiameter());
    }
}



