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
            System.out.println("Null Tree");
            return ;
        }

        System.out.println("InOrder Traversal : ");
        while(stack!=null || stack.size()>0) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    public void preOrder(Tree root) {

    }

    public void postOrder(Tree root) {
        
    }

    public static void main(String[] args) {
        AllTreeTraversals tree = new AllTreeTraversals();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        //inOrder
        tree.inOrder(tree.root);
        //preOrder
        tree.preOrder(tree.root);
        //postOrder
        tree.postOrder(tree.root);
    }
}
