/*
 * Another very interesting problem goes as: Given two rooted trees T1 and T2, you want to make T1 as structurally similar to T2. For doing that you can insert leaves one by one in any of the trees. You have to tell the minimum number of insertions required to do so.
 */

clas TreeNode{
    List<TreeNode> children;
}

public class TreeEditDistance {
    // dp[u1][u2] stores the minimum number of insertions needed to make subtree rooted at u1 and u2 identical
    static int[][] dp;

    // function to compute the dp table
    static int computeMinInsertions(TreeNode root1, TreeNode root2){
        // initialize a dp array with -1 (unvisited states)
        dp = new int[sizeOfTree(root1)][sizeOfTree(root2)];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i]);
        }
        return dfs(root1, root2);
    }

    static int dfs(TreeNode node1, TreeNode node2){
        // base case
        if (node1 == null && node 2 == null) return 0;

        // if one node is null and the other is not, we need to insert all children of the non-null node
        if (node1 == null) return countNodes(node1);
        if (node2 == null) return coutNodes(node1);

        // if the result is already computed for this pair, return it
        if (dp[node1.id][node2.id] != -1) return dp[node1.id][node2.id];
        List<TreeNode> children1 = node1.children;
        List<TreeNode> children2 = node2.children;

        int m = children1.size();
        int n = children2.size();

        // create a dp table to compute the minimum insertion for aligning children
        int[][] childDP = new int[m + 1][n + 1];

        // initialize base cases for child comparison
        for (int i = 0; i <= m; i++) childDP[i][0] = i // insert all childern of child 1
        for (int j = 0; j <= n; j++) childDP[0][j] = j;
        

        // compare the children using a nested for loop
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                int align = dfs(children.get(i - 1), children2.get(j -1));

                // insert child of node1
                int insert1 = childDP[i - 1][j] + 1;
                int insert2 = childDP[i][j - 1] + 1;

                // take th minimim of these options
                childDP[i][j] = Math.min(aligm, Math.min(insert1, insert2));
            }
        }

        return dp[node1.id][node2.id] = childDP[m][n];
    }

    // function to count number of nodes
    static int countNodes(TreeNode node){
        if (node == null) return 0;
        int count = 1;
        for (TreeNode child : node.children) {
            count += countNodes(child);
        }
        return count;
    }

    // function to get size of the tree
    static int sizeOfTree(TreeNode node){
        return countNodes(node);
    }
}

