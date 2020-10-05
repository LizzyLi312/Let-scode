class Solution {
    private Stack<TreeNode> stack = new Stack<>();
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return root;
        inorder(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            temp.val +=sum;
            sum = temp.val;
        }
        return root;
    }
    private void inorder(TreeNode root){ //bst's inorder is an increasing array
        if(root == null) return;
        inorder(root.left);
        stack.push(root);
        inorder(root.right);
    }
}
