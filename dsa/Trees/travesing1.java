
class Node {
    int key;
    Node left, right;

    public Node(int item){
        key = item;
        left = right = null;
    }

}

class BinaryTree{
    Node root;

    BinaryTree(){
        root = null;
    }

    void printPreorder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.key + " ");

        printPreOrder(node.left);

        prinrPreOrder(node.right);
    }

     // Wrappers over above recursive functions
    void printPreorder() { printPreorder(root); }

    // Driver code
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
            "Preorder traversal of binary tree is ");
        tree.printPreorder();
    }
}


