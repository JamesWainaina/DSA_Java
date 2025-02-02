class Node{
    int val;
    Node left, right;

    Node (int val){
        this.val = val;
    }
}

public class validateBst {
    static boolean isBSTUtil(Node node, long min, long max){
        if (node == null) return true;

        if (node.val <= min || node.val >= max)return false;

        return isBSTUtil(node.left, min, node.val) && 
        isBSTUtil(node.right, node.val , max);
    }

    //function to check if the entire binary tree is a BST
    static boolean isBST(Node root){
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
