class TreeNode{
    int val;
    TreeNode left, right;
}
public class kthSmallestBinaryTree {
    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = {0};
        return helper(root, cnt, k);
    }

    public int helper(TreeNode root, int[] cnt, int k){
        if (root == null){
            return -1;
        }

        int left = helper(root.left, cnt, k);

        if (left != -1) return left;
        cnt[0]++;

        if (cnt[0] == k) return root.val;

        return helper(root.right, cnt, k);

    }
}
