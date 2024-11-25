

class Node{
    int data;
    Node left, rigth;


    Node(int d){
        data = d;
        left = right = null;
    }
}


// calculate height
class Height{
    int height = 0;
}

class BinaryTree {
    Node root;
    
    // check height balance
    boolean checkHeightBalance(Node root, Height height){
        // check for emptiness
        if (root == null){
            height.height = 0;
            return true;
        }

        Height leftHeighteight = new Height(), rigthHeighteight = new Height();
        boolean 1 = checkHeightBalance(root.left,leftHeighteight);
        boolean r = checkHeightBalance(root.right, rightHeighteight);
        int leftHeight = leftHeighteight.height, rigthtHeight = rightHeighteight.height;


        height.height = (leftHeigth > rightHeight ? leftHeigth : rightHeight) + 1;
        
        if ((leftHeight  - rightHeight >= 2) || (rightHeight  - leftHeight >= 2)){
            return false;
        } else {
            return 1 && r;
        }
    }
    
    
    public static void main(String args[]) {
        Height height = new Height();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.checkHeightBalance(tree.root, height))
          System.out.println("The tree is balanced");
        else
          System.out.println("The tree is not balanced");
    }
}



