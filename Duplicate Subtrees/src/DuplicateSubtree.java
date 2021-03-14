import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtree {
    static Tree root;
    public static void main(String[] args) {
        root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.right = new Tree(4);
        root.right.right = new Tree(2);
        root.right.right.left = new Tree(3);

        List<Tree> dups = findDups(root);
        for(Tree t : dups) {
            System.out.println(t.data);
        }
    }

    private static List<Tree> findDups(Tree root) {
        Map<String, List<Tree>> map = new HashMap<String, List<Tree>>();
        List<Tree> dups = new ArrayList<Tree>();
        serialize(root, map);
        for (List<Tree> group : map.values())
            if (group.size() > 1) dups.add(group.get(0));
        return dups;
    }

    private static String serialize(Tree node, Map<String, List<Tree>> map) {
        if (node == null) return "";
        String s = "(" + serialize(node.left, map) + node.data + serialize(node.right, map) + ")";
        if (!map.containsKey(s)) map.put(s, new ArrayList<Tree>());
        map.get(s).add(node);
        return s;
    }
}
