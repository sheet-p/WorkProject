public class BTreeMaxPathSum {
    static int max_sum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        if(root == null)
            System.out.print("0");
        System.out.println(maxPath(root));
    }

    public static int maxPath(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(maxPath(node.left), 0);
        int right_gain = Math.max(maxPath(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }
}
