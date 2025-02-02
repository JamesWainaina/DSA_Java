class Node{
    int key;
    Node left, right;
}

public class flattenBinaryTree {
    static Node newNode(int key){
        Node node = new Node();
        node.key = key;
        node.left = node.right = null;
        return node;
    }

    static void flatten(Node root){
        // traverse till root is not null
        while(root != null){
            if (root.left != null){
                Node curr = root.left;

                // traverse extreme right of curr
                while (curr.right != null){
                    curr = curr.right;
                }

                // jion curr -> right to root -> right
                curr.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
