//LeetCode 979. Distribute Coins in Binary Tree
public class DistributeCoins {

    private static int moves = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(0);

        if(root == null)
            System.exit(0);
        traverse(root);
        System.out.println(moves);
    }

    private static int traverse(TreeNode root) {
        if(root == null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        moves += Math.abs(left) + Math.abs(right);
        return root.val + left + right -1;
    }
}
