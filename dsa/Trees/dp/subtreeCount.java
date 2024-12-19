/*
 * Given a tree T of N nodes and an integer K, find number of different sub trees of size less than or equal to K.
 */


public class SubtreeCount {
    static List<List<Integer>> adj;
    static int[] subtreeSize;
    static int k;
    static int count = 0;

    public static void dfs(int node, int parent){
        subtreeSize[node] = 1; // size of the subtree rooted at 'node' starts as 1(itself)
        for (int child : adj.get(node)){
            if (child != parent){
                dfs(child, node);
                subtreeSize[node] += subtreeSize[child];
            }
        }

        if (subtreeSize[node] <= k){
            count++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // input the number of nodes
        int N = sc.nextInt();

        // input l
        k = sc.nextInt();

        // initialize adjacency list
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++){
            adj.add(new ArrayList<>());
        }

        subtreeSixe = new int[N + 1];

        // input the edges of the tree
        for (int i = 1; i < N; i++){
            int u = sc.nexInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
            
        }

        // start dfs
        dfs(1, -1);

        // output the result
        Sysytem.out.println("Number of subtrees of size <-" + K + " :"+ count);
        sc.close();
    }
}


