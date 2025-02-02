
import java.lang.Math;


class Node{
    int data;
    Node left, right;

    Node (int x){
        data = x;
        left = null;
        right = null;
    }
}

public class diameterTree {
    static int diameterRecur(Node root, int[] res){
        if (root == null){
            return 0;
        }

        // find the height of left and right subtree
        int lHeight = diameterRecur(root.left, res);
        int rHeight = diameterRecur(root.right, res);

        // check if root is greater than res
        res[0] = Math.max(res[0], lHeight + rHeight);

        return 1 + Math.max(lHeight, rHeight);
    }

    static int diameter(Node root){
        int[] res = new int[1];
        diameterRecur(root, res);
        return res[0];
    }
}
