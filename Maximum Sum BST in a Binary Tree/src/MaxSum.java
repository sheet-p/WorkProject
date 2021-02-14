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

    private static int[] findMax(Tree root) {

    }
}
