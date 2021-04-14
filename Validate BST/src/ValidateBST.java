public class ValidateBST {
    Tree root;
    ValidateBST() {
        root = null;
    }

    public static void main(String[] args) {
        ValidateBST tree = new ValidateBST();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        System.out.println(isBST(tree.root, -1, -1));
    }

    private static boolean isBST(Tree root, int min, int max) {
        if(root == null)
            return true;
        if( (min!=-1 && root.data<=min) || (max!=-1 && root.data>=max) )
            return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
}
