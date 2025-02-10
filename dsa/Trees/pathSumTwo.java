// we have an array where we check if the path of that array is in the tree

class PathSum{
    public boolean pathSum(Node root, int[] arr){
        if (root == null){
            return arr.length == 0;
        }
        return helper(root, arr, 0);
    }

    public boolean helper(Node root, int[] arr, int index){
        if (root == null){
            return null;
        }

        if (index >= arr.length && node.val != arr[index]){
            return false;
        }

        // if we reach the leaf node and the last index of the array
        if (root.left == null && root.right == null && index == arr.length - 1){
            return true;
        }

        return helper(root.left, arr, index + 1) || helper(root.right, arr, index + 1);
    }
}