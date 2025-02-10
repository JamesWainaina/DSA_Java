
class countLeaves{
    public int countLeaves(Node root){
        if (root == null){
            return 0;
        }

        // check if the current node is the route
        if (root.left == null && root.right == null){
            return 1;
        }

        int leftLeaves = countLeaves(root.left);
        int rightLeaves = countLeaves(root.right);

        return leftLeaves + rightLeaves;
    }
}