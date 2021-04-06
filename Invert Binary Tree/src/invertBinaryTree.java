import java.util.LinkedList;
import java.util.Queue;

//Iterative Solution
//https://leetcode.com/problems/invert-binary-tree/submissions/
public class invertBinaryTree {
    static Tree root;

    public static void main(String[] args) {
        root = new Tree(3);
        root.left =  new Tree(2);
        root.left.left = new Tree(1);
        root.left.right = new Tree(4);
        root.right = new Tree(5);
        root.right.left = new Tree(6);

        root = invert(root);

        inOrderT(root);

    }

    private static void inOrderT(Tree root) {
        if(root == null)
            return ;

        inOrderT(root.left);
        System.out.println(root.data);
        inOrderT(root.right);

    }

    private static Tree invert(Tree root) {
        if(root == null)
            return null;

        //data structure for temp storage
        Queue<Tree> q = new LinkedList<>();

        q.add(root);

        while(! q.isEmpty()) {
            Tree current = q.poll();

            Tree temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null)
                q.offer(current.left);
            if(current.right != null)
                q.offer(current.right);
        }

        return root;
    }
}
