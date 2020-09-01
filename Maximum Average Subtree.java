class Solution {
    private double res = -Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        findMax(root);
        return res;
    }
    private int[] findMax(TreeNode root){
        if(root == null) return new int[]{0, 0}; //sum fo subtree, # of children
        int[] left = findMax(root.left);
        int[] right = findMax(root.right);
        int sum = left[0] + right[0] + root.val;
        int children = left[1] + right[1] + 1;
        res = Math.max(res, 1.0 * sum / children);
        return new int[] {sum, children};
    }
}

//time: O(n)
