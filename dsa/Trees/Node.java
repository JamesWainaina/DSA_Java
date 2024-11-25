

class Node{
    int item;
    Node left, right;

    public Node(int key){
        item = key;
        left = right = null;
    }
}


class BinaryTree{
    Node root;
    
    BinaryTree(){
        root = null;
    }

    // left, right, root
    void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.item + "->");
    }

    // left, root, right
    void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);

        System.out.println(node.item + "->");

        inOrder(node.right);
    }


    // root node, left, right
    void preOrder(Node node){
        if (node == null){
            return;
        }

        Sytem.out.print(node.item + "->");

        preOrder(node.left);
        preOrder(node.left);
        preOrder(node.right);
    }

    
    public static void main(String[] args) {
      BinaryTree tree = new BinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(12);
      tree.root.right = new Node(9);
      tree.root.left.left = new Node(5);
      tree.root.left.right = new Node(6);

      System.out.println("Inorder traversal");
      tree.inorder(tree.root);

      System.out.println("\nPreorder traversal ");
      tree.preorder(tree.root);

      System.out.println("\nPostorder traversal");
      tree.postorder(tree.root);
    }
}

