import java.util.*;
import java.util.ArrayList;

public class rightSideView{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = ArrayList<>();

        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                if (currentNode != null){

                    if (i == levelSize - 1){
                        res.add(currentNode.val);
                    }
                    if (currentNode.left != null){
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null){
                        queue.offer(currentNode.right);
                    }
                }
            }
        }
        return res;
     }                         
}
