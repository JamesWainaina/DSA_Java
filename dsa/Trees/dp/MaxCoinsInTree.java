
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * The first problem we solve is as follows: Given a tree T of N nodes, where each node i has Ci coins attached with it. You have to choose a subset of nodes such that no two adjacent nodes(i.e. nodes connected directly by an edge) are chosen and sum of coins attached with nodes in chosen subset is maximum.
 */

public class MaxCoinsInTree{
    static List<List<Integer>> adj; // represent the tree.
    static int[] dp1, dp2; // dp[i] if we include node i, dp2[i] if we exclude node i
    static int[] C; // coins associated with each node
 

    // Depth-First Search
    public static void dfs(int V, int pV){
        int sum1 = 0, sum2 = 0;

        // traverse over all the children of node V
        for (int v : adj.get(V)){
            if (v == pV) continue; // skip the parent node

            dfs(v, V); // recurr for child node 'v'


            // if we include the current node V, we cannot include it s child, so we add dp2[child]
            sum1 += dp2[v];
            // if we don't include the current node v, we can either include or exclude the child
            sum2 += Math.max(dp1[v], dp2[v]);
        }

        dp1[V] = C[V] + sum1;
        dp2[V] = sum2;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // input number of nodes
        int n = sc.nextInt();

        // initilaize the adjascent list
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        // initialize DP arrays and coin array
        dp1 = new int[n + 1];
        dp2 = new int[n + 1];

        C = new int[n + 1];

        // input the coins associated with each node
        for (int i = 1; i <= n; i++){
            C[i] = sc.nextInt();
        }

        // input edges
        for (int i = 1; i < n; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v); // add v as a neighbour of u
            adj.get(v).add(u); // Add u as a neighbour of v (udirected tree)
        
        }

        // start dfs from node 1 (assuing 1 i the root, with parent 0)
        dfs(1, 0);

        int ans = Math.max(dp1[1], dp2[1]);

        System.out.println(ans);
        
        sc.close();
    }
}








