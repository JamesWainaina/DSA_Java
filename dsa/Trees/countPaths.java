import java.util.LinkedList;
import java.util.List;
class Node {
    int val;
    Node left, right;

    Node(int val){
        this.val = val;
    }
}
public class countPaths {
    int countPaths(Node node, int sum){
        List<Integer> paths = new ArrayList<>();
        return helper(node, sum, paths);
    }

    int helper(Node node, int sum, List<Integer> paths){
        if (node == null){
            return 0;
        }
        paths.add(node.val);
        int count = 0;
        int s = 0; 
        ListIterator<Integer> itr = paths.listIterator(path.size());

        while(itr.hasPrevious()){
            s += itr.previous();

            if (s == sum){
                count++;
            }
        }
        count += helper(node.left, sum, paths) + helper(node.right, sum, paths);
        path.remove(path.size(0) - 1);

        return count;
    }

}
