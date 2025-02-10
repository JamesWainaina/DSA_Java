import java.util.*;
class Node {
    int val;
    Node left, right;

    Node(int val){
        this.val = val;
    }
}
public class BuldTreeII {
    Node buildUtil(List<Integer> inorder, List<Integer> postOrder,
    int inStrt, int inEnd, int[] pIndex, Map<Integer, Integer> mp){
        if (inStrt > inEnd){
            return null;
        }

        // get the current calue in postOrder
        int rootval = postOrder.get(pIndex[0]);
        Node root = new Node(rootval);
        pIndex[0]--;

        // if the current Node has no children, return the node
        if (inStrt == inEnd){
            return root;
        }

        //find the index of the current node's valus in the Inorder traversal
        int iIndex = mp.get(rootval);

        root.right = buildUtil(inorder, postOrder, iIndex + 1, inEnd, pIndex, mp);
        root.left = buildUtil(inorder, postOrder, inStrt, iIndex - 1, pIndex, mp);

        return root;

    }

    Node buildTree(List<Integer> inorder, List<Integer> postOrder){
        int len = inorder.size();

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < len; i++){
            mp.put(inorder.get(i), i);
        }

        // start from the last element
        int[] postIndex = new int[]{len - 1};

        return buildUtil(inorder, postOrder,0, len-1, postIndex, mp);
    }
}

