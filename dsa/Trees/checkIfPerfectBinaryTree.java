class CheckPerfectBinaryTree{
    // find the depth of the left most leaf as they should be on the same lavel
    public int findDepth(TreeNode root){
        int depth = 0;
        if (roor != null){
            depth++;
            node = node.left;
        }
        return depth;
    }   

    public boolean isPerfect(Node root, int depth, int level){
        if(node == null){
            return true;
        }
        if (node.left == null && node.right == null){
            return depth = level + 1;
        }
        if (node.left == null || node.right == null){
            return false;
        }

        return isPefect(node.left, depth, level + 1) && isPerfect(node.right, depth, level + 1);

    }

    public boolean isPerfect(Node root, int depth, int level){
        int depth = findDepth(depth);
        return isPerfect(root, depth, 0);
    }
}
