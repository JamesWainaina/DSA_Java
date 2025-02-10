class checkBalanceFactor{
    public int getHeight(Node root){
        if (root == null){
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }

    public int getBalanceFactor(Node root){
        if (root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight = rightHeight;
    }
}