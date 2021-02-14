import java.util.ArrayList;
import java.util.List;

public class Balance {
    Tree root;
    Balance() {
        root = null;
    }
    static List<Tree> sorted = new ArrayList<>();
    public static void main(String[] args) {
        Balance tree = new Balance();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        inOrder(tree.root);
        Tree node = sortedToBST(0, sorted.size()-1);

        inOrderT(node);

    }

    private static void inOrder(Tree root) {
        if(root == null)
            return ;
        inOrder(root.left);
        sorted.add(root);
        inOrder(root.right);
    }

    private static Tree sortedToBST(int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end)/2;
        Tree node = sorted.get(mid);

        node.left = sortedToBST(start, mid-1);
        node.right = sortedToBST(mid+1, end);

        return node;
    }

    private static void inOrderT(Tree root) {
        if(root == null)
            return ;

        inOrderT(root.left);
        System.out.println(root.data);
        inOrderT(root.right);

    }
}
