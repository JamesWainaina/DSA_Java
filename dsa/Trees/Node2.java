

// checking if a binary tree is a full binary tree 

class Node {
    int data;
    Node leftChild, rightChild;

    Node(int item){
        data = item;
        leftChild = rightChild = null;
    }
}

class BinaryTree{
    Node root;

    // check for full binary Tree
    boolean isFullBinaryTree(Node node){
        // checking tree emptiness
        if (node == null){
            return true;
        }

        // checking the children
        if ((node.leftchild == null) && (node.rightChild == null)){
            return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));
        }
        return false;
    }
    
     public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.rightChild.leftChild = new Node(6);
        tree.root.rightChild.rightChild = new Node(7);

        if (tree.isFullBinaryTree(tree.root))
          System.out.print("The tree is a full binary tree");
        else
          System.out.print("The tree is not a full binary tree");
  }


