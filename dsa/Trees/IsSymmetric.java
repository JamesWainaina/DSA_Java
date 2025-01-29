class Node{
    int data;
    Node left, right = null;

    Node(int val){
        data = val;
        left = right = null;
    }
}
public class IsSymmetric {
    static boolean isMirror(Node leftSub, Node rightSub){
        if (leftSub == null && rightSub == null){
            return true;
        }

        if (leftSub == null || rightSub == null || 
        leftSub.data != rightSub.data){
            return false;
        }

        // check if the subtrees are mirrors
        return isMirror(leftSub.left, rightSub.right) && 
        isMirror(leftSub.right, rightSub.left);
    }

    static boolean IsSymmetric(Node root){
        if (root == null){
            return true;
        }

        return isMirror(root.left, root.right);
    }

    
}
