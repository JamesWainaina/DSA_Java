import java.util.HashMap;
import java.util.Map;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int val){
        this.val = val;
    }
}

public class BuildTree {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }
        int[] preIndex = {0};
        return buildTreeRecur(mp, preorder, preIndex, 0, inorder.length-1);
    }

    public TreeNode buildTreeRecur(Map<Integer, Integer> mp, int[] preorder, int[] preIndex, int left, int right){
        if (left > right){
            return null;
        }
        int rootVal = preorder[preIndex[0]];

        // move to the next element in the preOrder
        preIndex[0]++;

        TreeNode root = new TreeNode(rootVal);

        // find the index of the root array in the arry
        int index  = mp.get(rootVal);

        //recursively create the right and left subtree
        root.left = buildTreeRecur(mp, preorder, preIndex, left, index - 1);
        root.right = buildTreeRecur(mp, preorder, preIndex, index + 1, right);

        return root;
    }
    
}
