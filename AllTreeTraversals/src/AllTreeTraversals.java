import java.util.Stack;

public class AllTreeTraversals {
    Tree root;
    AllTreeTraversals() {
        root = null;
    }

    public void inOrder(Tree root) {
        Stack<Tree> stack = new Stack<>();
        Tree curr = root;
        if(curr == null) {
            System.out.println("");
            return ;
        }
        inOrder(curr.left);
        System.out.print(curr.val + " ");
        inOrder(curr.right);
    }

    public void preOrder(Tree root) {
        Stack<Tree> stack = new Stack<>();
        Tree curr = root;
        if(root == null) {
            System.out.println("");
            return ;
        }

        System.out.print(curr.val + " ");
        preOrder(curr.left);
        preOrder(curr.right);
    }

    public void postOrder(Tree root) {
        Stack<Tree> stack = new Stack<>();
        Tree curr = root;
        if(root == null) {
            System.out.println("");
            return ;
        }

        postOrder(curr.left);
        postOrder(curr.right);
        System.out.print(curr.val + " ");
    }

    public static void main(String[] args) {
        AllTreeTraversals tree = new AllTreeTraversals();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        System.out.println("Traversals ");
        //inOrder
        System.out.println("InOrder Traversal : ");
        tree.inOrder(tree.root);
        //preOrder
        System.out.println("PreOrder Traversal : ");
        tree.preOrder(tree.root);
        //postOrder
        System.out.println("PostOrder Traversal : ");
        tree.postOrder(tree.root);
    }
}
