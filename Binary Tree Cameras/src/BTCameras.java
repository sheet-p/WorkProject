public class BTCameras {
    private static int NOT_MONITORED = 0;
    private static int MONITORED_NOCAM = 1;
    private static int MONITORED_WITHCAM = 2;
    private static int cameras = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        if (root == null)
            System.exit(0);
        int top = dfs(root);
        System.out.println(cameras + (top == NOT_MONITORED ? 1 : 0));
    }

    private static int dfs(TreeNode root) {
        if (root == null)
            return MONITORED_NOCAM;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //check for leaf node
        if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
            return NOT_MONITORED;
        }
        //check for parent of a leaf node and then add cam
        else if (left == NOT_MONITORED || right == NOT_MONITORED) {
            cameras++;
            return MONITORED_WITHCAM;
        }
        else {
            return MONITORED_NOCAM;
        }
    }
}
