class Node{
    int val;
    Node left, right;

    Node (int val){
        this.val;
    }
}

class SerializeAndDerialize{
    public String serialize(TreeNode root){
        List<String> list = new ArrayList<>();
        helper(root, list);
        return String.join(",", list);
    }

    void helper(TreeNode node, List<String> list){
        if (node == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }

    public TreeNode deserialize(String data){
        String[] values = data.split(",");
        // convert the values into a list so that we can perform operations
        List<String> list = new ArrayList<>(Arrays.asList(values));

        return helper2(list);
    }

    public TreeNode helper2(List<String> list){
        String val = list.remove(0);

        if (val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }
}