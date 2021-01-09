import java.util.*;
//LeetCode 236
public class LowestCommonAncestor {
    Tree root;

    LowestCommonAncestor() {
        root = null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Tree(1);
        tree.root.left = new Tree(3);
        tree.root.right = new Tree(2);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(6);
        tree.root.left.right.left = new Tree(5);

        Tree p = tree.root.left.left;
        Tree q = tree.root.left.right.left;
        //keeping track of parents
        Map<Tree, Tree> parent = new HashMap<>();
        //traversal
        Stack<Tree> stack = new Stack<>();

        parent.put(tree.root, null);
        stack.push(tree.root);

        System.out.print("Most Lowest Common Ancestor of " + p.val + " and " + q.val + " : ");

        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            Tree curr = stack.pop();

            if(curr.left != null) {
                parent.put(curr.left, curr);
                stack.push(curr.left);
            }
            if(curr.right != null) {
                parent.put(curr.right, curr);
                stack.push(curr.right);
            }
        }
        //keeping track of ancestors of p
        Set<Tree> ancestors = new HashSet<>();
        while(p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while(! ancestors.contains(q)) {
            q = parent.get(q);
        }
        System.out.print(q.val);
    }

}
