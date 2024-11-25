

// Binary tree

class Node{
    int key;
    Node left, right

    public Node(int item){
        key = item;
        left = right = null;
    }
}


class BinaryTree{
    Node root;

    BinaryTree(int key){
        root = new Node(key);
    }

    BinaryTree(){
        root = null;
    }
    // traverse inorder
    public void traverseInorder(Node Node){
        if (node ! = null){
            traverseInorder(node.left);
            System.out.println(" " + node.key);
            traverseInOrder(node.right);
        }
    }

    // traverse PostOrder
    public void traversePostOrder(Node node){
        if (node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(" " + node.key);
        }
    }

    //traverse PreOrder
    public void traversePreOrder(Node node){
        if(node != null){

            System.out.println(" " + node.key);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
}


