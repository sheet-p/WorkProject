//https://leetcode.com/problems/validate-binary-search-tree/

public class isValid {
    static Tree root;

    public static void main(String[] args) {
        root = new Tree(5);
        root.left = new Tree(1);
        root.right = new Tree(4);
        root.right.left = new Tree(3);
        root.right.right = new Tree(6);

        System.out.println(isValidBST(root, null, null));
    }

    private static boolean isValidBST(Tree root, Integer min, Integer max) {
        if(root == null)
            return true;
        if( (min!=null && root.data<= min) || (max!=null && root.data >= max) )
            return false;
        return ((isValidBST(root.left, min, root.data)) && (isValidBST(root.right, root.data, max)) );

    }
}
