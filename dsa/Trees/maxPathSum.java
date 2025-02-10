class MaxPathSum{
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        helper(root);
        return ans;
    }
    int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        // check for negatives
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + root.val;

        ans = Math.max(ans, pathSum);
        return Math.max(left, right) + root.val;
    }
}