class sumNumbers{
    public int sumNumbes(TreeNode root){
        return helper(root, 0);
    }

    int helper(TreeNode root, int sum){
        if (root == null){
            return 0;
        }

        sum = sum * 10 + node.val;
        if (root.left == null && root.right == null){
            return true;
        }
        return helper(root.left, sum) + helper(root.right, sum);
    }
}