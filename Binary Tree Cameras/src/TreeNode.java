public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) {
        this.val = v;
        this.left = null;
        this.right = null;
    }
    TreeNode(int v, TreeNode l, TreeNode r) {
        this.val = v;
        this.left = l;
        this.right = r;
    }
}
