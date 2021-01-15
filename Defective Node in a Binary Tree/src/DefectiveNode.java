import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//Consider a binary tree, where an arbitary node has 2 parents i.e two nodes in the tree
// have the same child. Identify the defective node.
public class DefectiveNode {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(7);
        root.left.left = new Tree(4);
        root.left.right = new Tree(2);
        root.left.left.left = new Tree(1);
        root.left.right.left = root.left.left.left;
        //keeping track of visited
        Set<Tree> visited = new HashSet<>();
        System.out.println(isDefective(root, visited));
    }

    private static boolean isDefective(Tree root, Set<Tree> visited) {
        if(root == null)
            System.exit(0);
        if(! visited.add(root))
            return false;
        visited.add(root);
        isDefective(root.left, visited);
        isDefective(root.right, visited);
        return true;
    }
}
