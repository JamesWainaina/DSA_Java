

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode(int val) {
        this.val = val;
    }
}

class invertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return null;
        }

        TreeNode  left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        left = root.right;
        right = root.left;


        return root;
    }    
}
