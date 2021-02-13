public class BST {
    Tree root;
    BST() {
        root = null;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);

        int key = 4;
        boolean exists = search(tree.root, key);
        System.out.println(exists);

        int ins = 6;
        insert(tree.root, ins);
        inOrder(tree.root);
    }

    private static boolean search(Tree root, int key) {
        //base conditions
        if(root==null)
            return false;
        if(root.data==key)
            return true;
        if(root.data < key)
            return search(root.left, key);
        else {
            return search(root.right, key);
        }
    }

    private static void insert(Tree root, int key) {
        if(root == null) {
            Tree node = new Tree(key);
            return ;
        }

        if(root.data > key)
            insert(root.right, key);
        else
            insert(root.left, key);
    }

    private static void inOrder(Tree root) {
        if(root == null)
            return ;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }
}
