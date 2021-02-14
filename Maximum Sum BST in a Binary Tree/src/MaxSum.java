//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/submissions/
public class MaxSum {
    static int max;
    Tree root;
    MaxSum() {
        root = null;
    }

    public static void main(String[] args) {

        MaxSum tree = new MaxSum();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        max = 0;
        findMax(tree.root);
        System.out.println(max);
    }

    //int[] {1/0 --> BST or not, largest, smallest, sum}
    private static int[] findMax(Tree root) {
        if(root == null)
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        int[] left = findMax(root.left);
        int[] right = findMax(root.right);

        boolean isBST = left[0]==1 && right[0]==1 && (root.data>left[1]) && (root.data < right[2]);
        int sum = root.data + left[3] + right[3];

        if(isBST) {
            max = Math.max(max, sum);
        }

        return new int[]{isBST?1:0, Math.max(root.data, right[1]), Math.min(root.data, left[2]), sum};
    }
}
