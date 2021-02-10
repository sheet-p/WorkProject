import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    Tree root;
    LevelOrder() {
        root = null;
    }

    public static void main(String[] args) {
        LevelOrder tree = new LevelOrder();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        /*Method 1 - O(n^2) time complexity)
        int height = height(tree.root);

        for(int i=1; i<=height; i++) {
            levelO(tree.root, i);
        } */

        Queue<Tree> q = new LinkedList<>();
        q.add(tree.root);
        while(! q.isEmpty()) {
            Tree temp = q.poll();

            System.out.print(" " + temp.data);

            if(temp.left != null)
                q.offer(temp.left);

            if(temp.right != null)
                q.offer(temp.right);
        }
    }

    public static int height(Tree root) {
        if(root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);

        if(lheight > rheight)
            return 1+lheight;
        else
            return  1+rheight;
    }

    public static void levelO(Tree root, int level) {
        if(root == null)
            return ;
        if(level == 1)
            System.out.print(" " + root.data);
        if(level > 1) {
            levelO(root.left, level-1);
            levelO(root.right, level-1);
        }
    }
}
