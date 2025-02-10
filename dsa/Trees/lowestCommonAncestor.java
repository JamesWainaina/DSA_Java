class TreeNode{
    int val;
    TreeNode left, right;
}

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode lca = lowestCommonAncestor(root.left, p, q);
        TreeNode rca = lowestCommonAncestor(root.right, p, q);

        if (lca != null && rca != null){
            return root;
        }
        return  (lca != null) ? lca : rca;
    }

}
