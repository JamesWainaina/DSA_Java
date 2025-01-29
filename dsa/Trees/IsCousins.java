import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left, right;

    Node(int x){
        data = x;
        left = right = null;
    }
}

class IsCousins{
    static boolean IsCousins(Node root, int a, int b){
        // base case
        if (root == null) return false;

        // return false if a and b are equal
        if (a == b) return false;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        

        while(!q.isEmpty()){
            int s = q.size();
            boolean aFound = false, bfound = false;

            for (int i = 0; i < s; i++){
                Node curr = q.poll();

                if (curr.data == a){
                    aFound = true;
                }
                if (curr.data == b){
                    bfound = true;
                }


                // if a anf b are children of the same node return false
                if (curr.left != null && curr.right != null){
                   if ((curr.left.data == a && curr.right.data == b) ||
                        (curr.left.data == b && curr.right.data == a)){
                        return false;
                    }
                 
                }
                

                 // push left node into
                 if (curr.left != null){
                    q.add(curr.left);
                 }

                 // push right node into q
                 if (curr.right != null){
                    q.add(curr.right);
                 }

                 // if both a and b are found return true
                 if (aFound && bfound){
                    return true;
                 }

                 // if a or b is found return false
                 if (aFound || bfound){
                    return false;
                 }
            }
        }
        return false;
    }
}