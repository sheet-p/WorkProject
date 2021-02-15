import javax.swing.*;

//https://www.youtube.com/watch?v=4wPlA_InnGY&feature=emb_logo
public class CountComplete {
    Tree root;
    CountComplete() {
        root = null;
    }

    public static void main(String[] args) {
        CountComplete tree = new CountComplete();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        System.out.print(complete(tree.root));

    }

    private static int complete(Tree root) {
        int lheight = left(root);
        int rheight = right(root);

        if(lheight == rheight)
            return (int) Math.pow(2, lheight) -1;

        return 1 + complete(root.left) + complete(root.right);
    }

    private static int left(Tree root) {
        if(root == null)
            return 0;
        return 1+left(root.left);
    }

    private static int right(Tree root) {
        if(root == null)
            return 0;
        return 1+right(root.right);
    }
}
