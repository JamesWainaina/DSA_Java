

// checking if a binary tree is a complete binary tree

class Node{
    int data;
    Node left, right;

    Node(int item){
        data = item;
        left = right = null;
    }
}


class completeBinaryTree{
    Node root;

    int countNumNodes(Node root){
        if (root == null){
            return (0);
        }
        return ( 1 + countNumNodes(root.left) + countNumNodes(root.right));
    }

    // check for complete binary tree
    boolean checkComplete(Node root, int index, int numberNodes){
        // check if the tree is empty
        if (root == null){
            return true;
        }

        if (index >= numberNodes){
            return false;
        }

        return (checkComplete(root.left, 2 * index + 1, numberNodes)
                && checkComplete(root.left, 2 * index + 2, numberNodex));
    }

    public static void main(String args[]) {
        binarytree tree = new binarytree();

        tree.root = new node(1);
        tree.root.left = new node(2);
        tree.root.right = new node(3);
        tree.root.left.right = new node(5);
        tree.root.left.left = new node(4);
        tree.root.right.left = new node(6);

        int node_count = tree.countnumnodes(tree.root);
        int index = 0;

        if (tree.checkcomplete(tree.root, index, node_count))
          system.out.println("the tree is a complete binary tree");
        else
          system.out.println("the tree is not a complete binary tree");
          }
    }
}
