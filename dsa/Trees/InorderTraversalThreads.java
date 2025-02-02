class Node{
    int data;
    Node left, right;
    boolean rightThread;
}

class InorderTraversalThreads {
    Node leftMost(Node n){
        if (n == null){
            return null;
        }
        while(n.left != null){
            n = n.left;
        }
        return n;
    }

    void Inorder(Node root){
        Node cur = leftMost(root);
        while (cur != null) {
            System.out.printf("%d", cur.data);
        }

        // if this node is a thread node then to inorder successor
        if (cur.rightThread){
            cur = cur.right;
        }else{
            cur = leftMost(cur.right);
        }
    }
}


