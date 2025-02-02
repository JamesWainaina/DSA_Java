class Node{
    Node left, right;
    int info;
    boolean lThread;
    boolean rThread;
}
public class InsertThreadedBinaryTree {
    static Node insert(Node root, int ikey){
        Node ptr  = root;
        Node par = null;
        while (ptr != null){
            if (ikey == (ptr.info)){
                System.out.println("Duplicate key !/n");
                return root;
            }

            par = ptr;

            if (ikey < ptr.info){
                if (ptr.lThread == false){
                    ptr = ptr.left;
                }else{
                    break;
                }
            }else{
                if (ptr.rThread == false){
                    ptr = ptr .right;
                }else {
                    break;
                }
            }

            // create  new node 
            Node tmp = new Node();
            tmp.info = ikey;
            tmp.lThread = true;
            tmp.rThread = true;


            if (par == null){
                root  = tmp;
                tmp.left = null;
                tmp.right = null;
            } else if (ikey < (par.info)){
                tmp.left = par.left;
                tmp.right = par;
                par.lThread = false;
                par.left = tmp;
            }else{
                tmp.left = par;
                tmp.right = par.right;
                par.rThread = false;
                par.right = tmp;
            }
        }
    }
}
