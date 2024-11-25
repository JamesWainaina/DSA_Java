

class BinarySearchTree{
    class Node{
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }


    Node root;

    BinarySearchTree(){
        root = null;
    }

    void insert(int key){
        root = insertKey(root, key);
    }

    // insert key in the tree
    Node insertKey(Node root, int key){
        // return a new noed if the tree is empty
        if (root == null){
            root = new Node(key);
            return root;
        }

        // traverser to the rigth place and insert the node
        if (key < root.key){
            root.left = insertKey(root.left, key);
        } else if (key > root.key){
            root.right = insertKey(root.right, key);
        }

        return root;
    }

    void inorder(){
        inorderRec(root);
    }

    // Inorder Traversal
    void inorderRec(Node root){
        if (root != null){
            inorder(root.left);
            System.out.println(root.key + " -> ");
            inorderRec(root.right);
        }
    }

    void deleteKey(int key){
        root = deleteRec(root, key);
    }

    Node deletekey(Node rootm int key){
        // return if the tree is empty
        if (root == null){
            return root;
        }

        // find the node to be deleted
        if (key < root.key){
            root.left = delete(root.left, key);
        } else if (key > root.key){
            root.right = deleteRec(root.right, key);
           
        } else{
            // if the node is only one child or no child 
            if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            }

            // if the node has two children
            // place the inorder successor in  positio of the node to be deleted
            root.key = minValue(root.right);


            // delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // find the inorder successor
    int minValue(Node root){
        int minv = root.key;
        while (root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

     public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.deleteKey(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}





