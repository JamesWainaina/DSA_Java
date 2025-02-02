class Node{
    int val;
    Node left , right;

    Node(int val){
        this.val = val;
    }
}

class sortedArrayBinaryTree {
    static Node sortedArrayToBSTRecur(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        Node root = new Node(arr[mid]);

        // left subtree
        root.left = sortedArrayToBSTRecur(arr, start, mid - 1);
        
        //right subtree
        root.right = sortedArrayToBSTRecur(arr, mid + 1, end);

        return root;
    }   

    static Node sortedArrayTpBST(int[] arr) {
        return sortedArrayToBSTRecur(arr, 0, arr.length - 1);
    }
}
