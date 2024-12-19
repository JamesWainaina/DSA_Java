/*
 * Given a tree T, where each node i has cost Ci. Steve starts at root node, and navigates to one node that he hasn't visited yet at random. Steve will stop once there are no unvisited nodes. Such a path takes total time equal to sum of costs of all nodes visited. What node should be assigned as root such that expected total time is minimised?
 *
 *
 *   Steps
 *   1. Input the tree and costs of nodes.
    2. Compute the size of each subtree using DFS.
    3. Compute the initial traversal cost for an arbitrary root.
    4. Use dynamic programming to calculate traversal costs for all nodes by re-rooting the tree.
    5. Find the node with the minimum expected traversal cost.
 *
 */

class minTraversalCost{
    static List<List<Integer>> adj;
    static int[] C; // cost at each node
    static int[] subtreeSize;
    static long[] cost; // total cost of traversalmit node is root
    static int N; // number of nodes


    public static void dfs1(int node, int parent){
        subtreeSize[node] = 1;
        cost[node] = C[node];

        for (int child : adj.get(node)){
            if (child != parent){
                dfs1(child, node);
                subtreeSize[node] += subtreeSize[child];
                cost[node] += cost[child] + subtreeSize[child] * C[node];
            }
        }
    }

    public static void dfs2(int node, int parent){
        for (int child: adj.get(node)){
            if (child != parent) {

                // re-root the tree at child and update the cost
                cost[child] = cost[node] - subtreeSize[child]  * C[child]  + (N - subtreeSize[child]) * C[node];
                dfs2(child, node);
            }
        }
    }

    public static int findOptimalRoot(){
        // dfs to calculate subtree sizes
        dfs(1, -1);

        // dfs for calculating cost for all node by rerooting
        dfs2(1, -1);

        // step 3 find the node with the minimum traversal cost
        int optimalNode = 1;

        long minCost = cost[1];

        for (int i = 2; i <= N; i++){
            if (cost[i] < minCost){
                mincost= cost[i];
                optimalNode = i;
            }
        }

        return optimalNode;
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes
        N = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // Input node costs
        C = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            C[i] = sc.nextInt();
        }
         // Input the edges
        for (int i = 1; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Initialize arrays
        subtreeSize = new int[N + 1];
        cost = new long[N + 1];

        // Find the optimal root
        int optimalRoot = findOptimalRoot();
        System.out.println("Optimal Root: " + optimalRoot);
    }
}


