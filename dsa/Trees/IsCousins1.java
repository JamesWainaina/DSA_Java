
class Node{
    int val;
    Node left, right;

    Node(int x){
        val = x;
        left = right = null;

    }
}

public class IsCousins1 {
    public boolean IsCousins(Node root, int x, int y){
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return(
            (level(root, xx, 0) == level(root, yy, 0)) &&
            (isSibling(root, xx, yy))
        );
    }

    Node findNode(Node node, int x){
        if(node == null){
            return null;
        }

        if (node.val == x){
            return node;
        }

        Node n = findNode(node.left, x);
        if (n != null){
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(Node node, Node x, Node y){
        if (node == null){
            return false;
        }

        return(
            (node.left == x && node.right == y) ||
            (node.left == y && node.right == x) ||
            isSibling(node.left, x, y)
            || isSibling(node.right, x, y)
        );
    }

    int level (Node node, Node x, int level){
        if (node == null){
            return 0;
        }

        if (node == x){
            return level;
        }
        int l = level(node.left, x, level + 1);
        if (l != 0){
            return l;
        }
        return level(node.right, x, level + 1);
    }   
}
