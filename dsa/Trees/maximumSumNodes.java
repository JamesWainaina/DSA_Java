import java.util.Vector;

/*
 * Given a tree with N nodes and N-1 edges, calculate the maximum sum of the node values from root to any of the leaves without re-visiting any node.
 *
 */

class GFG{
    static int[] dp = new int[100];

    static void dfs(int[] a, Vector<Integer>[] v, int u, int parent){
        dp[u] = a[u - 1]; // means the maximum sum at the current node starts with the value od node itself

        // stores the maximum value from nodes
        int maximum = 0;

        // traverse the tree
        for (int child : v[u]){
            // if child is a parent, then we continue
            // without recursing further
            if (child == parent){
                continue;
            }

            // call dfs for further traversal
            dfs(a, v, child, u);


            // store the maximum of previous visited
            // node and present visited node
            maximum = Math.max(maximum, dp[child]);
         }
          // add the maximum value returned 
          // to the parent node
          dp[u] += maximum;
    }
        // function that returns the maximum value 
     static int maximumValue(int[] a, Vector<Integer>[] v){
            dfs(a, v, 1, 0);
            return dp[1];
     }

     public static void main(String[] args){
         int n = 14;

         // adjacent list
         @SuppressWarnings("unchecked")
         Vector<Integer>[] v = new Vector[n + 1];

         for(int i = 0; i < v.length; i++){
             v[i] = new Vector<>();
         }

         v[1].add(2); v[2].add(1);
        v[1].add(3); v[3].add(1);
        v[1].add(4); v[4].add(1);
        v[2].add(5); v[5].add(2);
        v[2].add(6); v[6].add(2);
        v[3].add(7); v[7].add(3);
        v[4].add(8); v[8].add(4);
        v[4].add(9); v[9].add(4);
        v[4].add(10); v[10].add(4);
        v[5].add(11); v[11].add(5);
        v[5].add(12); v[12].add(5);
        v[7].add(13); v[13].add(7);
        v[7].add(14); v[14].add(7);


        int a[]  = { 3, 2, 1, 10, 1, 3, 9, 1, 5, 3, 4, 5, 9, 8};

        System.out.println(maximumValue(a, v));
     }
}

